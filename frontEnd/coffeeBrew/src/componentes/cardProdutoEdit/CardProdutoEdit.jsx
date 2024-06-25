import React, { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function CardProdutoEdit() {
  return (
    <div>CardProdutoEdit
        <label htmlFor="">pesquise por id</label>
        <input type="text" />

        <div className="formAddProduto">
        <h2>Cadastrar Produto</h2>
        <form className="formularioProdutoAdd" onSubmit={handleSubmit}>
          <label className="labelAddproduto">Nome:</label>
          <input
            className="inputFormAddProduto"
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
            className="inputFormAddProduto"
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
          <label className="labelAddproduto">Tipo:</label>
          <input
            className="inputFormAddProduto"
            type="text"
            name="tipo"
            value={produto.tipo}
            onChange={handleChange}
          />

          <button className="BotaoCadastrarProduto" type="submit">
            Cadastrar
          </button>
        </form>
    </div>
    </div>
  )
}

export default CardProdutoEdit