import React from "react";

function PageLoginFuncionario() {
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
      console.log("Funcionario logado com sucesso. ID:", response.data);
      setUsuarios(response.data);
      alert("Funcionario cadastrado com sucesso!");
      navigate("/inicio");
    } catch (error) {
      console.error("Erro ao cadastrar funcionario:", error);
      alert(
        "Erro ao cadastrar funcionario. Por favor, verifique os dados e tente novamente."
      );
    }
  };

  return (
    <div>
      PageLoginFuncionario
      <section>
        <form onSubmit={handleSubmit}>
          <label>CPF:</label>
          <input type="text" name="cpf" onChange={handleChange} required />
          <br />
          <label>Senha:</label>
          <input type="text" name="senha" onChange={handleChange} required />
          <br />
          <button type="submit">Entrar</button>
        </form>
      </section>
    </div>
  );
}

export default PageLoginFuncionario;
