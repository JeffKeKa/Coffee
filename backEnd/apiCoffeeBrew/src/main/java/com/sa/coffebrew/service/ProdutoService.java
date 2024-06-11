package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Produto;
import com.sa.coffebrew.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Long incluirProduto(Produto produto) {
        return produtoRepository.save(produto).getIdProduto();
    }

    public Boolean excluirProduto(Long idProduto) {
        try {
            produtoRepository.deleteById(idProduto);
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao excluir produto ID: " + idProduto + " Erro: " + ex.getLocalizedMessage());
            return false;
        }
    }

    public Optional<Produto> consultarProduto(Long idProduto) {
        return produtoRepository.findById(idProduto);
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Boolean atualizarProduto(Produto produto) {
        Optional<Produto> optionalProduto = produtoRepository.findById(produto.getIdProduto());
        if (optionalProduto.isPresent()) {
            Produto p = optionalProduto.get();
            p.setNome(produto.getNome());
            p.setPreco(produto.getPreco());
            p.setDescricao(produto.getDescricao());
            produtoRepository.save(p);
            return true;
        } else {
            return false;
        }
    }
}
