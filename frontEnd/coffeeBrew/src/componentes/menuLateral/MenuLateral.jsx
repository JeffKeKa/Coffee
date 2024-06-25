import React from "react";
import "./menuLateral.css";
import { Link } from "react-router-dom";
import { useContext } from "react";
import {  UsuarioContext } from "../../context/GlobalContext";
import FinalizarPedidoComponent from "../../service/apiPedido";
import { FaCoffee } from "react-icons/fa";
import { MdLunchDining } from "react-icons/md";
import { LuCupSoda } from "react-icons/lu";
import { GiCakeSlice } from "react-icons/gi";

function MenuLateral() {
const {urlProdutos, setUrlProdutos} = useContext(UsuarioContext);
const {Pedidos} = useContext(UsuarioContext)

  return (
    <div className="menuLateralbg">
      <div>
        <img 
          src="./imagensProduto\imagensLogo\logoSemFundo.png"
          className="logo"
        />
      </div>
        <button className="botoesPaginaMenu" onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Cafes <FaCoffee />
        </button>
        <button className="botoesPaginaMenu" onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Bebidas  <LuCupSoda /></button>
        <button className="botoesPaginaMenu" onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Salgados <MdLunchDining />
        </button>
        <button className="botoesPaginaMenu" onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Doces <GiCakeSlice /> </button><br /><br />

        {/* <button className="botoesPageMenu" onClick={()=>{finalizarPedido()}}> encaminhar pedido </button> */}
        <FinalizarPedidoComponent/>
    </div>
  );
}

export default MenuLateral;
