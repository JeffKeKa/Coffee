import React from "react";
import MenuLateral from "../../componentes/menuLateral/MenuLateral";
import "./pageMenu.css";
import CardProduto from "../../componentes/cardProduto/CardProduto";
function PageMenu() {
  return (
    <div className="MenuTotal">
      <div className="menuLateralPageMenu">
        <MenuLateral></MenuLateral>
      </div>
      <div className="menuCardPageMenu">
        <CardProduto></CardProduto>
        <CardProduto></CardProduto>
      
       
      </div>
    </div>
  );
}

export default PageMenu;
