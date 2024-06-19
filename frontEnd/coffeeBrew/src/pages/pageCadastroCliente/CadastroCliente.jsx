import React, { useState } from "react";
import axios from "axios";
import "./cadastroCliente.css";
import { Link } from "react-router-dom";

const CadastroCliente = () => {
  const [cliente, setCliente] = useState({
    nome: "",
    cpf: "",
    celular: "",
    email: "",
    senha: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setCliente((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post(
        "http://localhost:8010/coffebrew/cliente",
        cliente
      );
      console.log("Cliente cadastrado com sucesso. ID:", response.data);
      // Limpar o formulário após o cadastro
      setCliente({
        nome: "",
        cpf: "",
        celular: "",
        email: "",
        senha: "",
      });
      alert("Cliente cadastrado com sucesso!");
    } catch (error) {
      console.error("Erro ao cadastrar cliente:", error);
      alert(
        "Erro ao cadastrar cliente. Por favor, verifique os dados e tente novamente."
      );
    }
  };

  return (
    <div>
      <div className="cadastroCliente">
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
          <Link to="/login" className="botoesPageInicial">
            Login
          </Link>
        </div>
        <form className="formCadastroCliente" onSubmit={handleSubmit}>
          <h2>Cadastro de Cliente</h2>
          <label className="labelCadastroCliente">Nome:</label>
          <input
            className="imputCadstroCliente"
            type="text"
            name="nome"
            value={cliente.nome}
            onChange={handleChange}
            required
          />

          <label className="labelCadastroCliente">CPF:</label>
          <input
            className="imputCadstroCliente"
            type="text"
            name="cpf"
            value={cliente.cpf}
            onChange={handleChange}
            required
          />

          <label className="labelCadastroCliente">Celular:</label>
          <input
            className="imputCadstroCliente"
            type="text"
            name="celular"
            value={cliente.celular}
            onChange={handleChange}
            required
          />

          <label className="labelCadastroCliente">E-mail:</label>
          <input
            className="imputCadstroCliente"
            type="email"
            name="email"
            value={cliente.email}
            onChange={handleChange}
            required
          />

          <label className="labelCadastroCliente">Senha:</label>
          <input
            className="imputCadstroCliente"
            type="password"
            name="senha"
            value={cliente.senha}
            onChange={handleChange}
            required
          />

          <button className="buttonCadastrarCliente" type="submit">
            Cadastrar
          </button>
        </form>
      </div>
    </div>
  );
};

export default CadastroCliente;
