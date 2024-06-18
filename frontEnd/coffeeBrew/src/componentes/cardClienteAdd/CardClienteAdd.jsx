// src/components/CadastroCliente.js
import React, { useState } from 'react';
import axios from 'axios';

const CadastroClienteAdd= () => {
    const [cliente, setCliente] = useState({
        nome: '',
        cpf: '',
        celular: '',
        email: '',
        senha: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setCliente(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8010/coffebrew/cliente', cliente);
            console.log('Cliente cadastrado com sucesso. ID:', response.data);
            // Limpar o formulário após o cadastro
            setCliente({
                nome: '',
                cpf: '',
                celular: '',
                email: '',
                senha: ''
            });
            alert('Cliente cadastrado com sucesso!');
        } catch (error) {
            console.error('Erro ao cadastrar cliente:', error);
            alert('Erro ao cadastrar cliente. Por favor, verifique os dados e tente novamente.');
        }
    };

    return (
        <div>
            <h2>Cadastro de Cliente</h2>
            <form onSubmit={handleSubmit}>
                <label>Nome:</label>
                <input type="text" name="nome" value={cliente.nome} onChange={handleChange} required />
                <br />
                <label>CPF:</label>
                <input type="text" name="cpf" value={cliente.cpf} onChange={handleChange} required />
                <br />
                <label>Celular:</label>
                <input type="text" name="celular" value={cliente.celular} onChange={handleChange} required />
                <br />
                <label>E-mail:</label>
                <input type="email" name="email" value={cliente.email} onChange={handleChange} required />
                <br />
                <label>Senha:</label>
                <input type="password" name="senha" value={cliente.senha} onChange={handleChange} required />
                <br />
                <button type="submit">Cadastrar</button>
            </form>
        </div>
    );
};

export default CadastroClienteAdd;
