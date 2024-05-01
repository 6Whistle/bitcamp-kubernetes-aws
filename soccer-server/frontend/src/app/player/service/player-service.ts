import { instance } from "config/axios-config"

export const getOnPositionKey = ['repoData']
export const getOnPosition = async () => {
        const { data } = await instance().get(`/search`, { params : { "q": "player", "oq": "position" } })
    return data;
}
