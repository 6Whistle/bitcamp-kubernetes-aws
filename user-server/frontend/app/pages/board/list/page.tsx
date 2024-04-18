'use client'

import CardButton from "@/app/atoms/button/card-button"
import { IBoard } from "@/app/component/boards/model/board"
import { findAllBoards } from "@/app/component/boards/service/board-service"
import { getAllBoards } from "@/app/component/boards/service/board-slice"
import { useEffect } from "react"
import { useDispatch } from "react-redux"
import { useSelector } from "react-redux"

export default function BoardCards(){
    const dispatch = useDispatch()
    const allBoards:IBoard[] = useSelector(getAllBoards)

    useEffect(() => {
        dispatch(findAllBoards())
    }, [])  

    return (
        <ul className="flexcenter">
            {allBoards && allBoards.map((board:IBoard) => <CardButton key={board.id} id={board.id} title={board.title} description={board.description}/>)}
        </ul>
        )
}