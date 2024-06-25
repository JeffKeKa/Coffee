import React, { useContext } from "react";
import { UsuarioContext } from "../context/GlobalContext";
import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8010/coffebrew'
});

const FinalizarPedidoComponent = () => {

    const { pedidos, setPedidos } = useContext(UsuarioContext);

    const finalizarPedido = async () => {
        const nComanda = prompt(`Informe comanda`)
        try {
            const response = await api.put(`/pedido/${nComanda}`, pedidos); // Replace nComanda with your dynamic value
            console.log("Pedido finalizado:", response.data);
            // Handle success (e.g., show a success message)
        } catch (error) {
            console.error("Erro ao finalizar pedido:", error);
            // Handle error (e.g., show an error message)
        }

    };

    return (
        <button className="botoesPaginaMenu" onClick={finalizarPedido}>Finalizar Pedido</button>
    );
};

export default FinalizarPedidoComponent;
