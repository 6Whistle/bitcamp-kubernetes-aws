import { createSlice } from "@reduxjs/toolkit";
import { deleteArticle, findArticleById, findArticlesByBoardId, findArticlesCount, modifyArticle, saveArticle } from "./article-service";
import { IArticle } from "../model/article";

const status = {
    pending: "pending",
    fulfilled: "fulfilled",
    rejected: "rejected"
}

interface IArticleState{
    json?: IArticle,
    array?: IArticle[],
    count?: number
}

const initialState = {
    json: {} as IArticle,
    array: [] as IArticle[],
    count: 0
}

export const articleSlice = createSlice({
    name: "articles",
    initialState,
    reducers: {
        titleHandler: (state:any, {payload}:any) => { state.json.title = payload },
        contentHandler: (state:any, {payload}:any) => { state.json.content = payload },
        boardTitleHandler: (state:any, {payload}:any) => {state.json.boardTitle = payload },
        clearHandler: (state:any) => { state.json = {} as IArticle}
    },
    extraReducers: builder => {
        const {pending, rejected} = status
        builder
        .addCase(findArticleById.fulfilled, (state:any, {payload}: any) => {state.json = payload})
        .addCase(findArticlesCount.fulfilled, (state:any, {payload}:any) => {state.count = payload})
        .addCase(modifyArticle.fulfilled, (state:any, {payload}:any) => {})
        .addCase(deleteArticle.fulfilled, (state:any, {payload}:any) => {state.json = {} as IArticle})
        .addCase(findArticlesByBoardId.fulfilled, (state:any, {payload}:any) => {state.array = payload})
        .addCase(saveArticle.fulfilled, (state:any, {payload}:any) => {})
    }
})

export const getArticles = (state: any) => state.article.array
export const getOneArticle = (state: any) => state.article.json
export const getArticlesCount = (state: any) => state.article.count

export const { titleHandler, contentHandler, boardTitleHandler, clearHandler } = articleSlice.actions
export default articleSlice.reducer