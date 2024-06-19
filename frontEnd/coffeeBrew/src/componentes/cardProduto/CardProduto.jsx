import React, { useContext, useState, useEffect } from "react";
import axios from "axios";
import { UsuarioContext } from "../../context/GlobalContext";
import "./cardProduto.css";

function CardProduto() {
  const [produtos, setProdutos] = useState([]);
  const { urlProdutos } = useContext(UsuarioContext);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(urlProdutos);
        setProdutos(response.data);
      } catch (error) {
        console.error("Error:", error);
      }
    };
    fetchData();
  }, [urlProdutos]); // Adicionamos urlProdutos como dependência para que useEffect seja reexecutado quando a URL mudar

  return (
    <div className="menuCardPageMenu">
      {produtos.map((produto) => (
        <div key={produto.id} className="cardProdutoMenu">
          <img
            src="./imagensProduto/imagensCafe/produtoCafeAmericano.jpg"
            className="imagemCardProduto"
            alt={produto.nome}
          />
          <div className="informaçãoCardProduto">
            <h1 className="nomeCardProduto">{produto.nome}</h1>
            <h5 className="descricaoCardProduto">{produto.descricao}</h5>
            <div>
              <h1 className="">{produto.preco}</h1>
              <button className="">Comprar</button>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}

export default CardProduto;
