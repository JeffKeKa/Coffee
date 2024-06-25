import React from "react";
import CardProdutoEdit from "../../componentes/cardProdutoEdit/CardProdutoEdit";
import { Link } from "react-router-dom";
import { CiSettings } from "react-icons/ci";
import "./pageProdutoEdicao.css"

function PageProdutoEdicao() {
  return (
    <div className="pageProdutoEditar">
<div className="barraLateralPageInicial">
       
       <div>
         <img
           src="./imagensProduto\imagensLogo\logoSemFundo.png"
           className="logo"
         />
       </div>
       <Link to="/Menu" className="botoesPageInicial">
           Menu
         </Link>
         <Link to="/comandas" className="botoesPageInicial">
           Pagamento
         </Link>
         <Link to="/adicionarProduto" className="botoesPageInicial">
           Adicionar produto
         </Link>

         <Link to="/login" className="botoesPageInicial">
           Login
         </Link>
         <Link to="/pageloginfuncionario" className="botaoConfig">
         <CiSettings className="Configuracoes"/>
         </Link>
     </div>

      <CardProdutoEdit/>
    </div>
  );
}

export default PageProdutoEdicao;
