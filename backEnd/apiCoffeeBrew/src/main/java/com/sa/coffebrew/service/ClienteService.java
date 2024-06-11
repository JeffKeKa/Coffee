package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Cliente;
import com.sa.coffebrew.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Long incluirCliente(Cliente cliente) {
        return clienteRepository.save(cliente).getIdCliente();
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
}
