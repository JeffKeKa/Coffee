package com.sa.coffebrew.controller;

import com.sa.coffebrew.entity.Comanda;
import com.sa.coffebrew.service.ComandaService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

    @PostMapping("/comanda")
    public ResponseEntity<Comanda> incluirComanda(@RequestBody Comanda comanda) {
        Comanda comandaid = comandaService.incluirComanda(comanda);
        if(comandaid != null){
        return new ResponseEntity<>(comandaid, HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);            
        }
        
    }
    @DeleteMapping("/comanda/{id}")
    public ResponseEntity<Object> excluirComanda(@PathVariable(value = "id") Long id) {
        if (comandaService.excluirComanda(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/comanda/{idComanda}")
    public ResponseEntity<Comanda> consultarComanda(@PathVariable Long idComanda) {
        Optional<Comanda> comanda = comandaService.consultarComanda(idComanda);
        if (comanda.isPresent()) {
            return new ResponseEntity<>(comanda.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/comanda/numero/{nComanda}")
    public ResponseEntity<Comanda> consultarComandaPorNumero(@PathVariable Integer nComanda) {
        Comanda comanda = comandaService.consultarComandaPorNumero(nComanda);
        if (comanda != null) {
            return new ResponseEntity<>(comanda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/comanda")
    public ResponseEntity<List<Comanda>> listarComanda() {
        List<Comanda> comandas = comandaService.listarComanda();
        return new ResponseEntity<>(comandas, HttpStatus.OK);
    }

    @PutMapping("/comanda")
    public ResponseEntity<Object> atualizarComanda(@Valid @RequestBody Comanda comanda) {
        if (comandaService.atualizarComanda(comanda)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
