import React from "react";
import { Link } from "react-router-dom";
import { useEffect } from "react";

function PageInicial() {
  return (
    <div>
      <div className="">
        <div className="">
          <img
            // src="..\imagensProduto\imagensLogo\logoSemFundo.png"
            className=""
          />
          <Link to="/Menu" className="botoesInicio">
            Menu
          </Link>
          <Link to="/comanda" className="botoesInicio">
            Pagamento
          </Link>
          <Link to="/comanda" className="botoesInicio">
            Comanda
          </Link>
        </div>
        <div className="direitaInicio"></div>
        <p>PageInicial</p>
      </div>
    </div>
  );
}

export default PageInicial;
