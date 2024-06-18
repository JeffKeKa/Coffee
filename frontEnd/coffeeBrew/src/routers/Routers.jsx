import React from 'react'
import { createBrowserRouter } from 'react-router-dom'
import App from '../App'
import PageInicial from '../pages/pageInicial/PageInicial'
import PageMenu from '../pages/pageMenu/PageMenu'
import PageComandas from '../pages/pageComandas/PageComandas'
import CardProdutoAdd from '../componentes/cardProdutoAdd/CardProdutoAdd'

const Routers= createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        children: [
            {
                path:'/inicio',
                element:<PageInicial />
            },
            {
                path:'/menu',
                element:<PageMenu />
            },
            {
                path:'/comandas',
                element:<PageComandas />
            },
            {
                path:'/edicaoProdutos',
                element:<CardProdutoAdd />
            },
        ]
    }
])

export default Routers