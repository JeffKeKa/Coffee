import React, { useState } from "react";
import axios from "axios";
import "./cardProdutoEdit.css";

function CardProdutoEdit() {
  const [idProduto, setIdProduto] = useState("");
  const [produto, setProduto] = useState({
    id: "",
    nome: "",
    preco: 0,
    descricao: "",
    imgURL: "",
    tipo: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduto((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const pesquisarPorId = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.get(
        `http://localhost:8010/coffebrew/produto/${idProduto}`
      );
      console.log("Produto encontrado:", response.data);
      // Assuming response.data contains the product details
      setProduto(response.data);
    } catch (error) {
      console.error("Erro ao pesquisar produto:", error);
    }
  };

  const editarProduto = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.put(
        `http://localhost:8010/coffebrew/produto`,
        produto
      );
      console.log("Produto editado com sucesso. Novos dados:", response.data);
    } catch (error) {
      console.error("Erro ao editar produto:", error);
    }
  };

  const deletarProduto = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.delete(
        `http://localhost:8010/coffebrew/produto/${idProduto}`
      );
      console.log("Produto encontrado:", response.data);
      // Assuming response.data contains the product details
      setProduto(response.data);
    } catch (error) {
      console.error("Erro ao pesquisar produto:", error);
    }
  }

  return (
    <div>
      <div className="letraBlack formEditProduto">
        <h2>Editar Produto</h2>
        <label htmlFor="pesquisarProduto">Pesquisar por ID:</label>
        <input
        
          type="text"
           className="letraBlack inputFormAddProduto"
          id="pesquisarProduto"
          value={idProduto}
          onChange={(e) => setIdProduto(e.target.value)}
          required
        />
        <button className="letraBlack buttonProcurarProduto" onClick={pesquisarPorId}>
          Pesquisar
        </button>
        <form className="letraBlack formularioProdutoAdd" onSubmit={editarProduto}>
          <label className="letraBlack labelAddproduto">Nome:</label>
          <input
            className="letraBlack inputFormAddProduto"
            type="text"
            name="nome"
            value={produto.nome}
            onChange={handleChange}
            required
          />

          <label className="letraBlack labelAddproduto">Preço:</label>
          <input
            className="letraBlack inputFormAddProduto"
            type="number"
            name="preco"
            value={produto.preco}
            onChange={handleChange}
            required
          />

          <label className="letraBlack labelAddproduto">Descrição:</label>
          <textarea
            className="letraBlack inputFormAddProduto"
            type="text"
            name="descricao"
            value={produto.descricao}
            onChange={handleChange}
            required
          />

          <label className="letraBlack labelAddproduto">URL da Imagem:</label>
          <input
            className="letraBlack inputFormAddProduto"
            type="text"
            name="imgURL"
            value={produto.imgURL}
            onChange={handleChange}
          />

          <label className="letraBlack labelAddproduto">Tipo:</label>
          <input
            className="letraBlack inputFormAddProduto"
            type="text"
            name="tipo"
            value={produto.tipo}
            onChange={handleChange}
          />

          <button className="letraBlack BotaoCadastrarProduto" type="submit">
            Editar
          </button>
          <button className="letraBlack buttonDeleteProduto" onClick={deletarProduto}>Deletar</button>
        </form>
      </div>
    </div>
  );
}

export default CardProdutoEdit;
