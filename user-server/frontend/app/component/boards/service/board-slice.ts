import { createSlice } from "@reduxjs/toolkit"
import { deleteBoard, findAllBoards, findBoardById, findBoardsCount, modifyBoard } from "./board-service"
import { IBoard } from "../model/board"

interface boardState{
    array?: IBoard[],
    json?: IBoard,
    count?: number,
    message?: string,
}

const initialState = {
    array: [] as IBoard,
    json: {} as IBoard,
    count: 0,
    message: 0,
}

const status = {
    pending: "pending",
    fulfilled: "fulfilled",
    rejected: "rejected"
}

export const boardSlice = createSlice({
    name: "boards",
    initialState,
    reducers: {
        titleHandler: (state:any, {payload}:any) => {state.json.title = payload},
        descriptionHandler: (state:any, {payload}:any) => {state.json.description = payload}
    },
    extraReducers: builder => {
        const {pending, rejected} = status
        builder
        .addCase(findAllBoards.fulfilled, (state:any, {payload}: any) => {state.array = payload})
        .addCase(findBoardById.fulfilled, (state:any, {payload}: any) => {state.json = payload})
        .addCase(findBoardsCount.fulfilled, (state:any, {payload}: any) => {state.count = payload})
        .addCase(modifyBoard.fulfilled, (state:any, {payload}:any) => {})
        .addCase(deleteBoard.fulfilled, (state:any) => {state.json = {} as IBoard})
    }
})

export const getAllBoards = (state: any):IBoard[] => state.board.array
export const getSingleBoard = (state: any):IBoard => state.board.json
export const getBoardsCount = (state: any):number => state.board.count

export const { titleHandler, descriptionHandler } = boardSlice.actions
export default boardSlice.reducer