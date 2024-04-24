'use client'
import CardButton from "@/app/atoms/button/card-button"
import { IBoard } from "@/app/component/boards/model/board"
import { findAllBoards } from "@/app/component/boards/service/board-service"
import { getAllBoards } from "@/app/component/boards/service/board-slice"
import { useRouter } from "next/navigation"
import { useEffect } from "react"
import { useDispatch } from "react-redux"
import { useSelector } from "react-redux"

const cards = [
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/mountain-nightview.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/autumn.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/babypinetree.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/beach.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/purpleflowers.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/starrysky.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/lake.jpg",
  ];

export default function BoardCards(){
        const router = useRouter()
        const dispatch = useDispatch()
        const allBoards:IBoard[] = useSelector(getAllBoards)

        useEffect(() => {
            router.refresh()
            dispatch(findAllBoards(0))
        }, [])  

    return (
        <ul className="flexcenter">
            {allBoards && allBoards.map((board:IBoard, index) => <CardButton key={board.id} id={board.id} title={board.title} content={board.content} description={board.description} image={cards[index]}/>)}
        </ul>
        )
}