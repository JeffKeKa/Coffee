import React, { createContext, useState } from "react";
export const UsuarioContext = createContext();

export const UsuarioContextProvider = ({ children }) => {
  const [usuarios, setUsuarios] = useState(null);
  const [funcionarioLogado, setFuncionarioLogado] = useState(null);
  const [pedidos, setPedidos] = useState({});
  const [urlProdutos, setUrlProdutos] = useState("http://localhost:8010/coffebrew/produto")

  return (
    <UsuarioContext.Provider
      value={{ usuarios, setUsuarios, funcionarioLogado, setFuncionarioLogado, pedidos, setPedidos, urlProdutos, setUrlProdutos }}
    >
      {children}
    </UsuarioContext.Provider>
  );
};
