import React from 'react'
import { createBrowserRouter } from 'react-router-dom'
import App from '../App'
import PageInicial from '../pages/pageInicial/PageInicial'
import PageMenu from '../pages/pageMenu/PageMenu'
import PageComandas from '../pages/pageComandas/PageComandas'
import CardProdutoAdd from '../componentes/cardProdutoAdd/CardProdutoAdd'
import PageLogin from '../pages/pageLogin/PageLogin'
import CadastroCliente from '../pages/pageCadastroCliente/CadastroCliente'
import PageLoginFuncionario from '../pages/pageLoginFuncionario/PageLoginFuncionario'
import PageProdutoEdicao from '../pages/pageProdutoEdit/PageProdutoEdicao'


const Routers= createBrowserRouter([
    {
        path: "/",
        element: <App/>,
        children: [
            {
                path:'/',
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
                path:'/adicionarProduto',
                element:<CardProdutoAdd />
            },
            {
                path:'/login',
                element:<PageLogin />
            },
            {
                path:'/pageloginfuncionario',
                element:<PageLoginFuncionario/>
            },
            {
                path:'/cliente',
                element:<CadastroCliente />
            },
            {
                path:'/produtoEdicao',
                element:<PageProdutoEdicao/>
            },
        ]
    }
])

export default Routers