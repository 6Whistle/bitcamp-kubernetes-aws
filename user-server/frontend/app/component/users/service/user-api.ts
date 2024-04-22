import { API } from "@/app/component/common/enums/API"
import { RQ } from "../../common/enums/RQ"
import { IUser } from "../model/user"
import { createInstance } from "../../common/configs/axios-config"

export const findAllUsersAPI = async (page:number) => {
    try {
        console.log((await createInstance().get(`${API.USER}${RQ.LIST}`, {
            params: {page, size: 10, limit: 10}
        })))
        return <IUser[]>(await createInstance().get(`${API.USER}${RQ.LIST}`, {
            params: {page, size: 10, limit: 10}
        })).data
    } catch (error) {
        return error
    }
}

export const findUserByIdAPI = async (id:number) => {
    try {
        return (await createInstance().get(`${API.USER}${RQ.DETAIL}`, { params : {id} })).data
    } catch (error) {
        console.log(error)
        return error
    }
}

export const findUsersCountAPI = async () => {
    try {
        return (await createInstance().get(`${API.USER}${RQ.CNT}`)).data.message        
    } catch (error) {
        console.log(error)
        return error
    }
}

export const modifyUserAPI = async (user:IUser) => {
    try {
        return (await createInstance().put(`${API.USER}${RQ.MOD}`, user)).data        
    } catch (error) {
        console.log(error)
        return error
    }
}

export const deleteUserAPI = async (id:number) => {
    try {
        return (await createInstance().delete(`${API.USER}${RQ.DEL}`, {params : {id}})).data        
    } catch (error) {
        console.log(error)
        return error
    }
}

export const loginAPI = async (user:IUser) => {
    try {
        return (await createInstance().post(`${API.USER}/login`, user)).data
    } catch (error) {
        console.log(error)
        return error
    }
}

export const existByUsernameAPI = async (username:string) => {
    try {
        return (await createInstance().get(`${API.USER}/exist-username`, {params : {username}})).data.message
    } catch (error) {
        console.log(error)
        return error
    }
} 

export const logoutAPI = async (accessToken:string) => {
    try {
        return (await createInstance().post(`${API.USER}/logout`, accessToken)).data.message
    } catch (error) {
        console.log(error)
        return error
    }
}