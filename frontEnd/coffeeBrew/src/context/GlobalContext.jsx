import React, {createContext, useState } from 'react';
export const UsuarioContext = createContext();

export const UsuarioContextProvider = (({children}) =>
{const [usuarios, setUsuarios] = useState([
    {
        nome: 'cordenador',
        email: 'cordenador@cordenador',
    }
]);
    
    return (
        <UsuarioContext.Provider value={{usuarios}}>
            {children}
    </UsuarioContext.Provider>
    );
});
