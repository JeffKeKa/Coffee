// src/components/CadastroProduto.js
import React, { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import "./cardProdutoadd.css";

const CardProdutoAdd = () => {
  const [produto, setProduto] = useState({
    nome: "",
    preco: "",
    descricao: "",
    imgURL: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduto((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8010/coffebrew/produto",
        produto
      );
      console.log("Produto cadastrado com sucesso. ID:", response.data);
      // Limpar o formulário após o cadastro
      setProduto({
        nome: "",
        preco: "",
        descricao: "",
        imgURL: "",
      });
    } catch (error) {
      console.error("Erro ao cadastrar produto:", error);
    }
  };

  return (
    <div className="produtoAddPage">
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
        <Link to="/comandas" className="botoesPageInicial">
          Comanda
        </Link>
        <Link to="/edicaoProdutos" className="botoesPageInicial">
          Product Managment
        </Link>
      </div>
      <div className="formAddProduto">
       <h2>Cadastrar Produto</h2>
        <form className="formulario" onSubmit={handleSubmit}>
         <label className="labelAddproduto">Nome:</label>
         <input
           type="text"
           name="nome"
           value={produto.nome}
           onChange={handleChange}
           required
         />
         
         <label className="labelAddproduto">Preço:</label>
         <input
           className="inputFormAddProduto"
           type="number"
           name="preco"
           value={produto.preco}
           onChange={handleChange}
           required
         />
        
         <label className="labelAddproduto">Descrição:</label>
         <textarea
           name="descricao"
           value={produto.descricao}
           onChange={handleChange}
           required
         />
        
         <label className="labelAddproduto">URL da Imagem:</label>
         <input
           className="inputFormAddProduto"
           type="text"
           name="imgURL"
           value={produto.imgURL}
           onChange={handleChange}
         />
         
        
        <button className="BotaoCadastrarProduto" type="submit">Cadastrar</button>
      </form>
      </div>
    </div>
  );
};

export default CardProdutoAdd;
