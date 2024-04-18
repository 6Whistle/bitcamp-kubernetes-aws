import { createAsyncThunk } from "@reduxjs/toolkit";
import { deleteArticleAPI, findArticleByIdAPI, findArticlesByBoardIdAPI, findArticlesCountAPI, modifyArticleAPI, saveArticleAPI } from "./article-api";
import { IArticle } from "../model/article";

// export const findAllArticles:any = createAsyncThunk('articles/findAllArticles', async (page:number) => await findAllArticlesAPI(page))

export const findArticleById:any = createAsyncThunk('articles/findArticleById', async (id:number) => await findArticleByIdAPI(id))

export const findArticlesCount:any = createAsyncThunk('articles/findArticlesCount', async () => await findArticlesCountAPI())

export const modifyArticle:any = createAsyncThunk('articles/modifiyArticle', async (article: IArticle) => await modifyArticleAPI(article))

export const deleteArticle:any = createAsyncThunk('articles/deleteArticle', async (id:number) => await deleteArticleAPI(id))

export const findArticlesByBoardId:any = createAsyncThunk('articles/findArticlesByBoardId', async ({page, id}:any) => await findArticlesByBoardIdAPI(page, id))

export const saveArticle:any = createAsyncThunk('articles/saveArticle', async (article: IArticle) => await saveArticleAPI(article))