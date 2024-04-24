import { createAsyncThunk } from "@reduxjs/toolkit";
import { deleteUserAPI, existByUsernameAPI, findAllUsersAPI, findUserByIdAPI, findUsersCountAPI, loginAPI, logoutAPI, modifyUserAPI } from "./user-api";
import { IUser } from "../model/user";

export const findAllUsers:any = createAsyncThunk('users/findAllUsers', async (page:number) => await findAllUsersAPI(page))

export const findUserById:any = createAsyncThunk('users/findUserById', async (id:number) => await findUserByIdAPI(id))

export const findUsersCount:any = createAsyncThunk('user/findUsersCount', async () => await findUsersCountAPI())

export const modifyUser:any = createAsyncThunk('user/modifyUser', async (user:IUser) => await modifyUserAPI(user))

export const deleteUser:any = createAsyncThunk('user/deleteUser', async (id:number) => await deleteUserAPI(id))

export const login:any = createAsyncThunk('users/login', async (user:IUser) => await loginAPI(user))

export const existByUsername:any = createAsyncThunk('users/existByUsername', async (username:string) => await existByUsernameAPI(username))

export const logout:any = createAsyncThunk('users/logout', async () => await logoutAPI())