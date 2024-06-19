import React from 'react'
import { createBrowserRouter } from 'react-router-dom'
import App from '../App'
import PageInicial from '../pages/pageInicial/PageInicial'
import PageMenu from '../pages/pageMenu/PageMenu'
import PageComandas from '../pages/pageComandas/PageComandas'
import CardProdutoAdd from '../componentes/cardProdutoAdd/CardProdutoAdd'
import PageLogin from '../pages/pageLogin/PageLogin'
<<<<<<< HEAD
import CadastroCliente from '../pages/pageCadastroCliente/CadastroCliente'
=======
import PageLoginFuncionario from '../pages/pageLoginFuncionario/PageLoginFuncionario'
>>>>>>> 6da3481fd6fd4cb79d610120f70b3dc40ccc2dad

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
                path:'/edicaoProdutos',
                element:<CardProdutoAdd />
            },
            {
                path:'/login',
                element:<PageLogin />
            },
            {
<<<<<<< HEAD
                path:'/cadastroCliente',
                element:<CadastroCliente />
=======
                path:'/loginfuncionario',
                element:<PageLoginFuncionario />
>>>>>>> 6da3481fd6fd4cb79d610120f70b3dc40ccc2dad
            },
        ]
    }
])

export default Routers