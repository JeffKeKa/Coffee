import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8010/coffebrew'
})

export const loginCliente = async (login) => {
    return api.post('/cliente/login', login)
}