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
        <CardProduto />
  
    </div>
  );
}

export default PageMenu;
