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
      <div></div>
      <div className="botoesMenulateral">
        <button onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Cafes </button>
        <button onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Bebidas </button>
        <button onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Salgados </button>
        <button onClick={()=>{ setUrlProdutos("http://localhost:8010/coffebrew/produto")}}> Doces </button>
      </div>
    </div>
  );
}

export default MenuLateral;
