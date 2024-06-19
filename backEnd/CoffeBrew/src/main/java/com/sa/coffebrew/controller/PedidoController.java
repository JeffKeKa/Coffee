package com.sa.coffebrew.controller;

import com.sa.coffebrew.entity.Pedido;
import com.sa.coffebrew.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@RestController
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/pedido")
    public ResponseEntity<Long> incluirPedido(@RequestBody Pedido pedido, @RequestParam Long idProduto) {
        Long idPedido = pedidoService.incluirPedido(pedido, idProduto);
        if (idPedido != null && idPedido > 0) {
            return new ResponseEntity<>(idPedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pedido/{id}")
    public ResponseEntity<Void> excluirPedido(@PathVariable Long id) {
        if (pedidoService.excluirPedido(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pedido/{id}")
    public ResponseEntity<Pedido> consultarPedido(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.consultarPedido(id);
        if (pedido.isPresent()) {
            return new ResponseEntity<>(pedido.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pedido")
    public ResponseEntity<List<Pedido>> listarPedidos() {
        List<Pedido> pedidos = pedidoService.listarPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @PutMapping("/pedido")
    public ResponseEntity<Void> atualizarPedido(@Valid @RequestBody Pedido pedido, @RequestParam Long idProduto) {
        if (pedidoService.atualizarPedido(pedido, idProduto)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PutMapping("/pedido/{nComanda}")
    public ResponseEntity<Void> adicionarPedido(@PathVariable Integer nComanda,
                                                @Valid @RequestBody List<Pedido> pedidos) {
        if (pedidoService.incluirNovoPedido(pedidos, nComanda)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
