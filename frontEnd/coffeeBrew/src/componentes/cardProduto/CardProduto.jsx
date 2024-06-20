import React, { useContext, useState, useEffect } from "react";
import axios from "axios";
import { UsuarioContext } from "../../context/GlobalContext";
import "./cardProduto.css";

function CardProduto() {
  const [produtos, setProdutos] = useState([]);
  const { pedidos, setPedidos, urlProdutos } = useContext(UsuarioContext);

  const handleChange = (e) => {
    const { Q, value } = e.target;
    (prevState => ({
        ...prevState,
        [Q]: value
    }));
};

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

  const addProduto = async (produtoId, precoPedido) => {
    const pedidoFeito ={
      idproduto: produtoId,
      quantidade: Number(document.getElementById(produtoId).value),
      precototal: Number(document.getElementById(produtoId).value)*precoPedido,
      status: "em preparo",
    }

    const updatedPedidos = [...pedidos, pedidoFeito];

    setPedidos(updatedPedidos);
  };
  return (
    <div className="menuCardPageMenu">
      {produtos.map((produto) => (
        <div key={produto.idProduto} className="cardProdutoMenu">
          <img
            src="./imagensProduto/imagensCafe/produtoCafeAmericano.jpg"
            className="imagemCardProduto"
            alt={produto.nome}
          />
          <div className="informaçãoCardProduto">
            <h1 className="nomeCardProduto">{produto.nome}</h1>
            <h5 className="descricaoCardProduto">{produto.descricao}</h5>
            <div>
              <h1 className="" id={produto.preco}>{produto.preco}</h1>
              <button
                className=""
                onClick={() => addProduto(produto.idProduto, produto.preco)}
              >
                Comprar
              </button>
              <input type="number" name="" id={produto.idProduto} onChange={handleChange}/>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}

export default CardProduto;
