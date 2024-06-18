import "./cardProduto.css";
import React from "react";
import { useState, useEffect } from "react";
import axios from "axios";

function CardProduto() {
  return (
    <div>
      <section className="cardProdutoMenu">
        <img
          src="./imagensProduto\imagensCafe\produtoCafeAmericano.jpg"
          className="imagemCardProduto"
        />

        <div className="informaçãoCardProduto">
          <h1 className="nomeCardProduto">CAFÉ AMERICANO</h1>
          <h2 className="descricaoCardProduto">
            O café americano é uma bebida feita diluindo-se espresso em água
            quente, resultando em uma xícara suave e menos concentrada do que o
            espresso puro.
          </h2>
          <section className="">
            <h3 className="">R$30,00</h3>
            <button className="">Comprar</button>
          </section>
        </div>
      </section>
    </div>
  );
}

export default CardProduto;
