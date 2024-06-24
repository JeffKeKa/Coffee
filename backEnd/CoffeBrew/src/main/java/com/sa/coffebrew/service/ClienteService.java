    package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Cliente;
import com.sa.coffebrew.repository.ClienteRepository;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

    @Service
    public class ClienteService {

        @Autowired
        private ClienteRepository clienteRepository;

        public Long incluirCliente(Cliente cliente) {
               if(cliente.getNome() == null ||
               cliente.getCpf() == null ||
               cliente.getEmail() == null ||
               cliente.getSenha() == null ||
               cliente.getCelular() == null){
                
               return null;
               }

            String cpf = cliente.getCpf();
            Cliente cli = clienteRepository.findByCpf(cpf);
            
            if(cli == null){
            String senhaCli = cliente.getSenha();
            cliente.setSenha(this.codificarSenhaCliente(senhaCli));
            return clienteRepository.save(cliente).getIdCliente();
            }else{
            return null;
            }
        }

        public Boolean excluirCliente(Long idCliente) {
            try {
                clienteRepository.deleteById(idCliente);
                return true;
            } catch (Exception ex) {
                System.out.println("Erro ao excluir cliente ID: " + idCliente + " Erro: " + ex.getLocalizedMessage());
                return false;
            }
        }

        public Optional<Cliente> consultarCliente(Long idCliente) {
            return clienteRepository.findById(idCliente);
        }

        public List<Cliente> listarClientes() {
            return clienteRepository.findAll();
        }

        public Boolean atualizarCliente(Cliente cliente) {
            Optional<Cliente> optionalCliente = clienteRepository.findById(cliente.getIdCliente());
            if (optionalCliente.isPresent()) {
                Cliente c = optionalCliente.get();
                c.setCelular(cliente.getCelular());
                c.setNome(cliente.getNome());
                c.setCpf(cliente.getCpf());
                c.setEmail(cliente.getEmail());
                clienteRepository.save(c);
                return true;
            } else {
                return false;
            }
        }
        
        
        public Cliente loginCliente(String cpf, String senha){
        Cliente cli = clienteRepository.findByCpf(cpf);
        // System.out.println("Cliente: " + cli.getCpf());
        if(cli != null){
            String senhaCod = codificarSenhaCliente(senha);
            if(cli.getSenha().equals(senhaCod)){
                return cli;
            }            
        }
        return null;
    }
        
    public String codificarSenhaCliente(String senha){
        String senhaCod = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(senha.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            senhaCod = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.getLocalizedMessage();
        }
        return senhaCod;
    }
    }
