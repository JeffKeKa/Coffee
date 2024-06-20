import React from "react";
import "./menuLateral.css";
import { Link } from "react-router-dom";
import { useContext } from "react";
import { UsuarioContext } from "../../context/GlobalContext";

function MenuLateral() {
const {urlProdutos, setUrlProdutos} = useContext(UsuarioContext);

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

        <button className="botoesPageMenu" onClick={()=>{ setUrlProdutos(`http://localhost:8010/coffebrew/pedido/${124}`)}}> encaminhar pedido </button>
    </div>
  );
}

export default MenuLateral;
