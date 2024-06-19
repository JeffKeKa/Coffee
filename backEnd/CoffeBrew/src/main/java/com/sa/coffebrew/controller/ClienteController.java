package com.sa.coffebrew.controller;

import com.sa.coffebrew.entity.Cliente;
import com.sa.coffebrew.entity.Login;
import com.sa.coffebrew.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/cliente")
    public ResponseEntity<Long> incluirCliente(@RequestBody Cliente cliente) {
        Long idCliente = clienteService.incluirCliente(cliente);
        if (idCliente != null) {
            return new ResponseEntity<>(idCliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cliente/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        if (clienteService.excluirCliente(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<Cliente> consultarCliente(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.consultarCliente(id);
        if (cliente.isPresent()) {
            return new ResponseEntity<>(cliente.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/cliente")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PutMapping("/cliente")
    public ResponseEntity<Void> atualizarCliente(@Valid @RequestBody Cliente cliente) {
        if (clienteService.atualizarCliente(cliente)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping(value = "/cliente/login", consumes = {"application/json"})
    public ResponseEntity<Object> loginCliente(@Valid @RequestBody Login login){
       // System.out.println("cpf: " + login.getCpf() + " senha: " + login.getSenha());
        Cliente cli = clienteService.loginCliente(login.getCpf(), login.getSenha());
        if(cli != null){
            return new ResponseEntity<>(cli, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);            
        }
    }
}
