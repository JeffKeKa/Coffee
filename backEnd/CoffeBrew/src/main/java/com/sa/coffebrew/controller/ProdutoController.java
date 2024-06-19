package com.sa.coffebrew.controller;

import com.sa.coffebrew.entity.Produto;
import com.sa.coffebrew.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/produto")
    public ResponseEntity<Long> incluirProduto(@RequestBody Produto produto) {
        Long idProduto = produtoService.incluirProduto(produto);
        if (idProduto != null && idProduto > 0) {
            return new ResponseEntity<>(idProduto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        if (produtoService.excluirProduto(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> consultarProduto(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.consultarProduto(id);
        if (produto.isPresent()) {
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PutMapping("/produto")
    public ResponseEntity<Void> atualizarProduto(@Valid @RequestBody Produto produto) {
        if (produtoService.atualizarProduto(produto)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
