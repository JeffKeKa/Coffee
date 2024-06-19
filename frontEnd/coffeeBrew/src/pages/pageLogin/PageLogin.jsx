import React, { useContext, useState } from "react";
import { loginCliente } from "../../service/api";
import {useNavigate} from "react-router-dom"
import { UsuarioContext } from "../../context/GlobalContext";

function PageLogin() {
const [form, setForm] = useState ({cpf: '', senha: ''})
const {setUsuarios} = useContext(UsuarioContext)
const navigate = useNavigate()

  const handleChange = (e) => {  
    setForm({...form, [e.target.name]: e.target.value})
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await loginCliente(form)
      console.log("Cliente logado com sucesso. ID:", response.data);
      setUsuarios(response.data);
      alert("Cliente cadastrado com sucesso!");
      navigate("/menu")
    } catch (error) {
      console.error("Erro ao cadastrar cliente:", error);
      alert(
        "Erro ao cadastrar cliente. Por favor, verifique os dados e tente novamente."
      );
    }
  };

  return (
    <div>
      PageLogin
      <section>
        <form onSubmit={handleSubmit}>
          <label>CPF:</label>
          <input
            type="text"
            name="cpf"
            onChange={handleChange}
            required
          />
          <br />
          <label>Senha:</label>
          <input
            type="text"
            name="senha"
            onChange={handleChange}
            required
          />
          <br />
          <button type="submit">Entrar</button>
        </form>
      </section>
    </div>
  );
}

export default PageLogin;
