import React from "react";
import { Link } from "react-router-dom";
import { useEffect } from "react";
import "./pageInicial.css";
import { useState } from "react";
import CardProdutoAdd from "../../componentes/cardProdutoAdd/CardProdutoAdd";
import CardClienteAdd from "../../componentes/cardClienteAdd/CardClienteAdd";

function PageInicial() {
  const [index, setIndex] = useState(0);

  useEffect(() => {
    const intervalId = setInterval(() => {
      setIndex((prevIndex) => (prevIndex + 1) % 3);
    }, 3000);

    return () => {
      clearInterval(intervalId);
    };
  }, []);

  return (
    <div className="conteinerPageInicial">
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
        <Link to="/cadastroCliente" className="botoesPageInicial">
          Cadastro Cliente
        </Link>
      </div>
      {/* <div className="direitaPageInicial">
      <div className="carousel-slide imagensCarousel " style={{ display: index === 0 ? 'block' : 'none' }}>
          <img src="https://3.bp.blogspot.com/-gEIxd4Q5pU4/UTFWax73A3I/AAAAAAABr94/3DIoxR_NfnI/s1600/fotos-e-im%C3%A1genes-de-granos-de-caf%C3%A9-y-taza-coffee-photos-9.jpg"   className='imagensCarousel' /> 
        </div>

        <div className="carousel-slide imagensCarousel" style={{ display: index === 1 ? 'block' : 'none' }}>
        <img src="https://media-cdn.tripadvisor.com/media/photo-s/11/c3/1c/19/20170924-134626-largejpg.jpg"   className='imagensCarousel' /> 
        </div>

        <div className="carousel-slide imagensCarousel" style={{ display: index === 2 ? 'block' : 'none' }}>
        <img src="https://th.bing.com/th/id/OIP.0HRY6dUFgUyc1t-xyA1siAHaE8?rs=1&pid=ImgDetMain"   className='imagensCarousel' /> 
        </div>

      </div> */}

       {/* <CardProdutoAdd />  */}
      
    </div>
  );
}

export default PageInicial;
