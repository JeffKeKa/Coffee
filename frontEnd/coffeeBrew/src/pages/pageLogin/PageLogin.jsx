import React, { useContext, useState } from "react";
import { loginCliente } from "../../service/api";
import { useNavigate } from "react-router-dom";
import { UsuarioContext } from "../../context/GlobalContext";
import "./pageLogin.css";
import { Link } from "react-router-dom";

function PageLogin() {
  const [form, setForm] = useState({ cpf: "", senha: "" });
  const { setUsuarios } = useContext(UsuarioContext);
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await loginCliente(form);
      console.log("Cliente logado com sucesso. ID:", response.data);
      setUsuarios(response.data);
      alert("Cliente cadastrado com sucesso!");
      navigate("/menu");
    } catch (error) {
      console.error("Erro ao cadastrar cliente:", error);
      alert(
        "Erro ao cadastrar cliente. Por favor, verifique os dados e tente novamente."
      );
    }
  };

  return (
    <div className="pageLoginTotal">
      <section className="pageLoginTotal">
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
       
        <form className="formAddPageLogin" onSubmit={handleSubmit}>
           <h1>Login</h1>
          <label>CPF:</label>
          <input
            className="inputPageLogin"
            type="text"
            name="cpf"
            onChange={handleChange}
            required
          />
          <br />
          <label>Senha:</label>
          <input
            className="inputPageLogin"
            type="text"
            name="senha"
            onChange={handleChange}
            required
          />
          <br />
          <button className="buttonPageLogin" type="submit">
            Entrar
          </button>
        </form>
      </section>
    </div>
  );
}

export default PageLogin;
