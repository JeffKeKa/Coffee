import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8010/produto'
})

export const produtoCafe = async () => {
    return api.post('/')
}

