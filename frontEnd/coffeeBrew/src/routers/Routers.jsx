import React from 'react'
import { createBrowserRouter } from 'react-router-dom'
import App from '../App'
import PageInicial from '../pages/pageInicial/PageInicial'
import PageMenu from '../pages/pageMenu/PageMenu'
import PageComandas from '../pages/pageComandas/PageComandas'

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
        ]
    }
])

export default Routers