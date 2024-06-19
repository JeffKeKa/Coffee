import React from "react";
import "./menuLateral.css";
import { Link } from "react-router-dom";

function MenuLateral() {
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
        <Link to="/Menu" className="BotaoLateral">
          Cafes
        </Link>
        <Link to="/Menu" className="BotaoLateral">
          Salgados
        </Link>
        <Link to="/Menu" className="BotaoLateral">
          Sobremesas
        </Link>
        <Link to="/Menu" className="BotaoLateral">
          Bebidas
        </Link>
        
      </div>
    </div>
  );
}

export default MenuLateral;
