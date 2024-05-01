import { instance } from "config/axios-config"

export const getHeightAvgByTeamKey = ['getHeightAvgByTeam']
export const getHeightAvgByTeam = async () => {
        const { data } = await instance().get(`/search`, { params : { "q": "team", "oq": "height-avg" } })
    return data;
}

export const getTeamsKey = ['getTeams']
export const getTeams = async () => {
        const { data } = await instance().get(`/search`, { params : { "q": "team", "oq": "team-name-order" } })
    return data;
}

export const getNotSelectedPostionKey = ['getNotSelectedPostion']
export const getNotSelectedPostion = async () => {
        const { data } = await instance().get(`/search`, { params : { "q": "team", "oq": "no-position" } })
    return data;
}

export const getTeamsByteamNameKey = ['getTeamsByteamName']
export const getTeamsByteamName = async () => {
        const { data } = await instance().get(`/search`, { params : { "q": "team", "oq": "team-name" } })
    return data;
}

