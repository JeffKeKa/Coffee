import React, {createContext, useState } from 'react';
export const UsuarioContext = createContext();

export const UsuarioContextProvider = (({children}) =>
{const [usuarios, setUsuarios] = useState([
    
]);
    
    return (
        <UsuarioContext.Provider value={{usuarios, setUsuarios}}>
            {children}
    </UsuarioContext.Provider>
    );
});
