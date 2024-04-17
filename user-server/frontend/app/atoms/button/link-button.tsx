import { PG } from "@/app/component/common/enums/PG";
import Link from "next/link"

export interface ILinkButton{
    id?: number,
    title?: string,
    path?: string
}

export const linkButtonTitles:ILinkButton[] = [
    {id: 1, title: 'login', path: `/`}, 
    {id: 2, title: 'join', path: `${PG.USER}/join`}, 
    {id: 3, title: 'counter-redux', path: `${PG.DEMO}/redux-counter`}, 
    {id: 4, title: 'articles', path: `${PG.ARTICLE}/list`}, 
    {id: 5, title: 'users', path: `${PG.USER}/list`}, 
    {id: 6, title: 'board', path: `${PG.BOARD}/list`}];

export default function LinkButton({id, title, path} : ILinkButton){
    return <li key = {id}>
            <Link href={`${path}`} className="block py-2 px-3 text-gray-900 rounded hover:bg-gray-100 md:hover:bg-transparent md:hover:text-blue-700 md:p-0 dark:text-white md:dark:hover:text-blue-500 dark:hover:bg-gray-700 dark:hover:text-white md:dark:hover:bg-transparent dark:border-gray-700" aria-current="page">{title}</Link>
        </li>
}