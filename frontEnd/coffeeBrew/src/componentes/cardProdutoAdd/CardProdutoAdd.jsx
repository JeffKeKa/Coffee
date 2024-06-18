import React from "react";

function CardProdutoAdd() {
  return (
    <div>
      CardProdutoAdd
      <form action="">
        <label htmlFor="">Nome</label>
        <input type="text" />

        <label htmlFor="">Descrição</label>
        <input type="text" />

        <label htmlFor="">Preço</label>
        <input type="text" />

        <label htmlFor="">Imagem</label>
        <input type="text" />

        <input type="submit" value={"submit"} />
      </form>
    </div>
  );
}

export default CardProdutoAdd;
