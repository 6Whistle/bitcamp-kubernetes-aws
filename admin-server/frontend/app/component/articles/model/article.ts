export interface IArticle{
    id?: number,
    title?: string,
    content?: string,
    writer?: string,
    boardTitle?: string,
    regDate?: string,
    modDate?: string,
    json?: IArticle,
    array?: IArticle[],
    count?: number
}