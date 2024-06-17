import { useState } from 'react'
import './App.css'
import { Outlet } from 'react-router-dom' 
import { UsuarioContextProvider } from './context/GlobalContext'  
  
function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <UsuarioContextProvider>
        <Outlet/>
      </UsuarioContextProvider>
    </>
  )
}

export default App
