import React, { useState, useContext } from "react";
import "./pageComandas.css";
import axios from "axios";
import { UsuarioContext } from "../../context/GlobalContext";

function PageComandas() {
  const { comandas, setComandas } = useContext(UsuarioContext);
  const [inputComanda, setInputComanda] = useState("");

  const consultarComanda = async () => {
    try {
      const response = await axios.get(
        `http://localhost:8010/coffebrew/comanda/numero/${inputComanda}`
      );
      setComandas(response.data);
    } catch (error) {
      console.error("Error:", error);
    }
  };

  const handleInputChange = (event) => {
    setInputComanda(event.target.value);
  };

  return (
    <div className="pageComandas">
      <section className="barraLateralPageComandas">
        <div>
          <img
            src="./imagensProduto/imagensLogo/logoSemFundo.png"
            className="logo"
            alt="Logo"
          />
        </div>
        <form className="formularioPageComanda">
          <label className="labelAddproduto">Informe numero da comanda:</label>
          <input
            className="inputComanda"
            type="number"
            name="inputComanda"
            id="comandaInputInforme"
            value={inputComanda}
            onChange={handleInputChange}
            required
          />
          <button
            className="BotaoCadastrarProduto"
            type="button" // change type to button to prevent form submission
            onClick={consultarComanda}
          >
            Confirmar
          </button>
        </form>
        <button className="BotaoCadastrarProduto">Pagar</button>
      </section>

      <section>
        <table>
          <thead>
            <tr>
              <th>Produto</th>
              <th>Quantidade</th>
              <th>Preço</th>
            </tr>
          </thead>
          <tbody>
            {comandas &&
              comandas.pedidos &&
              comandas.pedidos.map((pedido, index) => (
                <tr key={index}>
                  <td>{pedido.produto.nome}</td>
                  <td>{pedido.quantidade}</td>
                  <td>{pedido.precoPedido}</td>
                </tr>
              ))}
          </tbody>
        </table>
      </section>
    </div>
  );
}

export default PageComandas;
