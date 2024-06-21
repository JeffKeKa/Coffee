import React, { useState } from "react";
import "./pageComandas.css";
import { Link } from "react-router-dom";
import axios from "axios";
import { useContext, useEffect } from "react";
import { UsuarioContext } from "../../context/GlobalContext";

function PageComandas() {
  const { comandas, setComandas } = useContext(UsuarioContext);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(`http://localhost:8010/coffebrew/comanda/numero/${22}`);
        setComandas(response.data);
      } catch (error) {
        console.error("Error:", error);
      }
    };
    fetchData();
  }, []);

  return (
    <div className="pageComandas">
      <section className="barraLateralPageComandas">
        <div>
          <img
            src="./imagensProduto\imagensLogo\logoSemFundo.png"
            className="logo"
          />
        </div>
        <form className="formularioPageComanda">
          <label className="labelAddproduto">Informe numero da comanda:</label>
          <input
            className="inputComanda"
            type="text"
            name="inputComanda"
            required
          />
          <button className="BotaoCadastrarProduto" type="submit">
            Confirmar
          </button>
        </form>
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
              comandas.pedidos.map((pedido) => (
                <tr>
                  <td>{pedido.produto.nome}</td>
                  <td>{pedido.quantidade}</td>
                  <td>{pedido.precoPedido}</td>
                </tr>
              )) }
          </tbody>
        </table>
      </section>
    </div>
  );
}

export default PageComandas;
