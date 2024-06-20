import React, { useState } from "react";
import './pageComandas.css'
import { Link } from "react-router-dom";
function PageComandas() {
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
          <input className="inputComanda" type="text" name="inputComanda" required />
          <button className="BotaoCadastrarProduto" type="submit">
            Confirmar
          </button>
        </form>
      </section>

      <section>
        <table>
          <tr>
            <th>Produto</th>
            <th>Quantidade</th>
            <th>preço</th>
          </tr>
          <tr>
            <td>Produto vindo do back</td>
            <td>Quantidade vindo do beck</td>
            <td>preço do back</td>
          </tr>
        </table>
      </section>
    </div>
  );
}

export default PageComandas;
