import React from "react";
import "./menuLateral.css";
import { Link } from "react-router-dom";
import { useContext } from "react";
import {  UsuarioContext } from "../../context/GlobalContext";
import FinalizarPedidoComponent from "../../service/apiPedido";

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
        <button className="botoesPageMenu" onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Cafes </button>
        <button className="botoesPageMenu" onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Bebidas </button>
        <button className="botoesPageMenu" onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Salgados </button>
        <button className="botoesPageMenu" onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Doces </button><br /><br />

        {/* <button className="botoesPageMenu" onClick={()=>{finalizarPedido()}}> encaminhar pedido </button> */}
        <FinalizarPedidoComponent/>
    </div>
  );
}

export default MenuLateral;
