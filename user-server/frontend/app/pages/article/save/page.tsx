"use client"

import { IArticle } from "@/app/component/articles/model/article"
import { saveArticle } from "@/app/component/articles/service/article-service"
import { boardTitleHandler, clearHandler, contentHandler, getOneArticle, titleHandler } from "@/app/component/articles/service/article-slice"
import { IBoard } from "@/app/component/boards/model/board"
import { findAllBoards } from "@/app/component/boards/service/board-service"
import { getAllBoards } from "@/app/component/boards/service/board-slice"
import { PG } from "@/app/component/common/enums/PG"
import { RQ } from "@/app/component/common/enums/RQ"
import MyTypography from "@/app/component/common/style/cell"
import { AttachFile, FmdGood, ThumbUpAlt } from "@mui/icons-material"
import { jwtDecode } from "jwt-decode"

import { useRouter } from "next/navigation"
import { parseCookies } from "nookies"
import { useEffect, useState } from "react"
import { useSelector } from "react-redux"
import { useDispatch } from "react-redux"
import { useForm } from "react-hook-form"

export default function NewArticlePage(){
    const router = useRouter();
    const dispatch = useDispatch()
    const boards:IBoard[] = useSelector(getAllBoards)
    const { register, handleSubmit, formState: { errors }, setValue } = useForm()

    const cancelHandler = () => {
      router.push(`${PG.BOARD}${RQ.LIST}`)
    }

    // const submitHandler = () => {
    //   if(article.title && article.content && article.boardTitle){
    //    dispatch(saveArticle({...article, writer: jwtDecode<any>(parseCookies().accessToken)?.username}))
    //    router.push(`${PG.BOARD}${RQ.LIST}`)
    //  }
    // }

    const onSubmit = (data:any) => 
      dispatch(saveArticle(data))
      .then((res:any) => 
        res.payload.message === "SUCCESS" ? 
        router.push(`${PG.ARTICLE}${RQ.LIST}/${boards.find((board) => board.title === data.boardTitle)?.id}`) : 
        alert("Failed To Save Article")
      )
    

    useEffect(() => {
        setValue("writer", jwtDecode<any>(parseCookies().accessToken)?.username)
        dispatch(findAllBoards())
    }, [])

    return <form className="max-w-2xl mx-auto" onSubmit={handleSubmit(onSubmit)}>
  <label htmlFor="boardTitle" className="block mb-2 text-sm font-medium text-gray-900 dark:text-white text-center">Select Board</label>
  <select id="boardTitle" defaultValue={boards && boards[0]?.title} {...register("boardTitle", {required: true, maxLength: 50})} className="bg-gray-50 border border-gray-300 text-gray-900 text-sm font-bold rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-auto p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 margincenter">
    {boards && boards.map(board => <option className="font-bold text-justify" key={board.id} value={board.title}>{board.title?.toUpperCase()}</option>)}
  </select>
  <br />
    <div className="editor mx-auto w-10/12 flex flex-col text-gray-800 border border-gray-300 p-4 shadow-lg max-w-2xl">
      {MyTypography('Article 작성', "1.5rem")}
      <input className="title bg-gray-100 border border-gray-300 p-2 mb-4 outline-none" placeholder="Title" type="text" {...register("title", { required: true, maxLength: 320})}/>
      <textarea className="description bg-gray-100 sec p-3 h-60 border border-gray-300 outline-none" placeholder="Describe everything about this post here" {...register("content", { required: true })} />
      {/* <!-- icons --> */}
      <div className="icons flex text-gray-500 m-2">
        <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <ThumbUpAlt component={ThumbUpAlt}></ThumbUpAlt>
        </svg>
        <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <FmdGood component={FmdGood}></FmdGood>
        </svg>
        <svg className="mr-2 cursor-pointer hover:text-gray-700 border rounded-full p-1 h-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
          <AttachFile component={AttachFile}></AttachFile>
        </svg>
        <div className="count ml-auto text-gray-400 text-xs font-semibold">0/300</div>
      </div>
      {/* <!-- buttons --> */}
      <div className="buttons flex">
        <div className="btn  overflow-hidden relative w-30 bg-white text-blue-500 p-3 px-4 rounded-xl font-bold uppercase -- before:block before:absolute before:h-full before:w-1/2 before:rounded-full
        before:bg-pink-400 before:top-0 before:left-1/4 before:transition-transform before:opacity-0 before:hover:opacity-100 hover:text-200 hover:before:animate-ping transition-all duration-00"
          onClick={cancelHandler}>Cancel</div>
        <input className="btn  overflow-hidden relative w-30 bg-blue-500 text-white p-3 px-8 rounded-xl font-bold uppercase -- before:block before:absolute before:h-full before:w-1/2 before:rounded-full
        before:bg-pink-400 before:top-0 before:left-1/4 before:transition-transform before:opacity-0 before:hover:opacity-100 hover:text-200 hover:before:animate-ping transition-all duration-00"
          type="submit" value="Post" />
      </div>
    </div>
    </form>
}