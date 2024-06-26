"use client";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import {
  getArticles,
  getArticlesCount,
} from "@/app/component/articles/service/article-slice";
import {
  findArticlesByBoardId,
  findArticlesCount,
} from "@/app/component/articles/service/article-service";
import ArticleColumns from "@/app/component/articles/module/article-columns";
import { DataGrid } from "@mui/x-data-grid";
import { IArticle } from "@/app/component/articles/model/article";
import MoveButton from "@/app/atoms/button/move-button";
import { PG } from "@/app/component/common/enums/PG";
import { RQ } from "@/app/component/common/enums/RQ";
import Link from "next/link";

const cards = [
  "https://www.tailwindtap.com/assets/components/horizontal-carousel/mountain-nightview.jpg",
  "https://www.tailwindtap.com/assets/components/horizontal-carousel/autumn.jpg",
  "https://www.tailwindtap.com/assets/components/horizontal-carousel/babypinetree.jpg",
  "https://www.tailwindtap.com/assets/components/horizontal-carousel/beach.jpg",
  "https://www.tailwindtap.com/assets/components/horizontal-carousel/purpleflowers.jpg",
  "https://www.tailwindtap.com/assets/components/horizontal-carousel/starrysky.jpg",
  "https://www.tailwindtap.com/assets/components/horizontal-carousel/lake.jpg",
];

export default function ArticleListPage({ params }: any) {
  const dispatch = useDispatch();
  const articles: IArticle[] = useSelector(getArticles);

  useEffect(() => {
    dispatch(findArticlesByBoardId({ page: 1, id: params.id }));
  }, []);

  return (
    <>
      <table
        className="table-auto w-4/5 border-x-black"
        style={{ margin: "50px auto" }}
      >
        <thead>
          <tr>
            <td>
              <div className="flex flex-col items-center justify-center w-full bg-white-300">
                <div className="flex overflow-x-scroll snap-x snap-mandatory max-w-6xl no-scrollbar">
                  {cards.map((data, index) => {
                    return (
                      <section
                        className="flex-shrink-0 w-full snap-center justify-center items-center"
                        key={index}
                      >
                        <img
                          src={data}
                          alt="Images to scroll horizontal"
                          className="w-full h-[500px]"
                        />
                      </section>
                    );
                  })}
                </div>
              </div>
            </td>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td
              align="center"
              className="w-full  bg-gray-400 border-black border-4 p-8 h-20 text-[20px]"
            >
              <Link
                href={`${PG.BOARD}${RQ.LIST}`}
                className="font-medium text-black dark:text-black hover:under"
              >
                {articles && articles[0]?.boardTitle?.toUpperCase()} Article
                List
              </Link>
            </td>
          </tr>
          <tr>
            <td align="center" className="h-300">
              {articles && (
                <DataGrid
                  rows={articles}
                  columns={ArticleColumns(params.id)}
                  initialState={{
                    pagination: {
                      paginationModel: {
                        pageSize: 5,
                      },
                    },
                  }}
                  pageSizeOptions={[5]}
                  checkboxSelection
                  disableRowSelectionOnClick
                />
              )}
            </td>
          </tr>
        </tbody>
      </table>
      <div className="flexcenter">
        <MoveButton
          text={`Write Article`}
          path={`${PG.ARTICLE}${RQ.SAVE}`}
        ></MoveButton>
      </div>
    </>
  );
}
