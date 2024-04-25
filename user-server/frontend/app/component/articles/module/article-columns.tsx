import { GridColDef } from "@mui/x-data-grid";
import { IArticle } from "../model/article";
import MyTypography from "../../common/style/cell";
import { PG } from "../../common/enums/PG";
import { RQ } from "../../common/enums/RQ";
import { useDispatch } from "react-redux";
import { deleteBoard } from "../../boards/service/board-service";
import Link from "next/link";

interface CellType{
    row: IArticle,
}

export default function ArticleColumns(boardId:number): GridColDef[]{
    return [
        {
            flex: 0.04,
            field: 'id',
            minWidth: 30,
            headerName: 'ID',
            renderCell: ({row}: CellType) => MyTypography(row.id, "1rem")
        },
        { 
            flex: 0.04,
            field: 'title',
            minWidth: 30,
            headerName: "Title", 
            renderCell: ({row}: CellType) => <Link href={`${PG.ARTICLE}${RQ.DETAIL}/${row.id}`}>{MyTypography(row.title, "1rem")}</Link>
        },
        { 
            flex: 0.04,
            field: 'content',
            minWidth: 30,
            headerName: "Content", 
            renderCell: ({row}: CellType) => MyTypography(row.content, "1rem")
        },
        { 
            flex: 0.04,
            field: 'writer',
            minWidth: 30,
            headerName: "writer", 
            renderCell: ({row}: CellType) => MyTypography(row.writer, "1rem")
        },
        { 
            flex: 0.04,
            field: 'boardTitle',
            minWidth: 30,
            headerName: "Board Title", 
            renderCell: ({row}: CellType) => MyTypography(row.boardTitle, "1rem")
        },
        { 
            flex: 0.04,
            field: 'regDate',
            minWidth: 30,
            headerName: "Register Date", 
            renderCell: ({row}: CellType) => MyTypography(row.regDate, "1rem")
        },
        { 
            flex: 0.04,
            field: 'modDate',
            minWidth: 30,
            headerName: "Modified Date", 
            renderCell: ({row}: CellType) => MyTypography(row.modDate, "1rem")
        },
        { 
            flex: 0.04,
            field: 'delete',
            minWidth: 30,
            headerName: "Delete", 
            renderCell: ({row}: CellType) => <Link href={`${PG.ARTICLE}${RQ.LIST}/${boardId}`}>{MyTypography("Delete", "1rem")}</Link>
        },
    ]
}
