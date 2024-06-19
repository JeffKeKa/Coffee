package com.sa.coffebrew.controller;

import com.sa.coffebrew.entity.Funcionario;
import com.sa.coffebrew.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/funcionario")
    public ResponseEntity<Long> incluirFuncionario(@RequestBody Funcionario funcionario) {
        Long idFuncionario = funcionarioService.incluirFuncionario(funcionario);
        if (idFuncionario != null && idFuncionario > 0) {
            return new ResponseEntity<>(idFuncionario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/funcionario/{id}")
    public ResponseEntity<Void> excluirFuncionario(@PathVariable Long id) {
        if (funcionarioService.excluirFuncionario(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<Funcionario> consultarFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.consultarFuncionario(id);
        if (funcionario.isPresent()) {
            return new ResponseEntity<>(funcionario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/funcionario")
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @PutMapping("/funcionario")
    public ResponseEntity<Void> atualizarFuncionario(@Valid @RequestBody Funcionario funcionario) {
        if (funcionarioService.atualizarFuncionario(funcionario)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
