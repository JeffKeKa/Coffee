// src/components/CadastroProduto.js
import React, { useState } from 'react';
import axios from 'axios';

const CardProdutoAdd = () => {
    const [produto, setProduto] = useState({
        nome: '',
        preco: '',
        descricao: '',
        imgURL: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setProduto(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8010/coffebrew/produto', produto);
            console.log('Produto cadastrado com sucesso. ID:', response.data);
            // Limpar o formulário após o cadastro
            setProduto({
                nome: '',
                preco: '',
                descricao: '',
                imgURL: ''
            });
        } catch (error) {
            console.error('Erro ao cadastrar produto:', error);
        }
    };

    return (
        <div>
            <h2>Cadastrar Produto</h2>
            <form onSubmit={handleSubmit}>
                <label>Nome:</label>
                <input type="text" name="nome" value={produto.nome} onChange={handleChange} required />
                <br />
                <label>Preço:</label>
                <input type="number" name="preco" value={produto.preco} onChange={handleChange} required />
                <br />
                <label>Descrição:</label>
                <textarea name="descricao" value={produto.descricao} onChange={handleChange} required />
                <br />
                <label>URL da Imagem:</label>
                <input type="text" name="imgURL" value={produto.imgURL} onChange={handleChange} />
                <br />
                <button type="submit">Cadastrar</button>
            </form>
        </div>
    );
};

export default CardProdutoAdd;
