package com.sa.coffebrew.controller;

import com.sa.coffebrew.entity.Comanda;
import com.sa.coffebrew.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@RestController
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

//    @PostMapping("/comanda")
//    public ResponseEntity<Long> incluirComanda(@RequestBody Comanda comanda,@PathVariable(value="idCliente") Long idCliente) {
//        Comanda comanda = comandaService.incluirComanda(comanda, idCliente);
//        if(idComanda  != null && idComanda  > 0)
//        {
//        return new ResponseEntity<>(idComanda , HttpStatus.OK);
//        }else 
//        {
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);            
//        }
//        
//    }

    @DeleteMapping("/comanda/{id}")
    public ResponseEntity<Object> excluirComanda(@PathVariable(value = "id") Long id) {
        if (comandaService.excluirComanda(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/comanda/{id}")
    public ResponseEntity<Comanda> consultarComanda(@PathVariable Long id) {
        Optional<Comanda> comanda = comandaService.consultarComanda(id);
        if(comanda.isPresent())
        {
            return new ResponseEntity<>(comanda.get(), HttpStatus.OK);
        } else 
        {       
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
