package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Produto;
import com.sa.coffebrew.repository.ProdutoRepository;
import com.sa.coffebrew.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProdutoServiceTest {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = new Produto();
        produto.setNome("Produto Teste");
        produto.setPreco(10.0);
        produto.setDescricao("Descrição do Produto Teste");
        produtoRepository.save(produto);
    }

    @Test
    void testIncluirProduto() {
        System.out.println("teste de incluir produto");
        Produto newProduto = new Produto();
        newProduto.setNome("Novo Produto");
        newProduto.setPreco(15.0);
        newProduto.setDescricao("Descrição do Novo Produto");

        Long idProduto = produtoService.incluirProduto(newProduto);
        assertNotNull(idProduto);

    }

    @Test
    void testExcluirProduto() {
        System.out.println("teste de incluir produto");
        Boolean result = produtoService.excluirProduto(produto.getIdProduto());
        assertTrue(result);

        Optional<Produto> foundProduto = produtoRepository.findById(produto.getIdProduto());
        assertFalse(foundProduto.isPresent());
    }

    @Test
    void testConsultarProduto() {
        System.out.println("teste de consultar produto");
        Optional<Produto> result = produtoService.consultarProduto(produto.getIdProduto());
        assertTrue(result.isPresent());
    }

    @Test
    void testListarProdutos() {
        System.out.println("teste de listar produto");
        List<Produto> result = produtoService.listarProdutos();
        assertFalse(result.isEmpty());
    }

    @Test
    void testAtualizarProduto() {
        System.out.println("teste de atualizar produto");
        produto.setDescricao("Descrição Atualizada");
        Boolean result = produtoService.atualizarProduto(produto);
        assertTrue(result);

        Optional<Produto> produtoAtualizado = produtoRepository.findById(produto.getIdProduto());
        assertTrue(produtoAtualizado.isPresent());
        
    }
    
    @Test
    void testIncluirProdutoSemPreco() {
        System.out.println("teste de incluir produto sem preco");
        Produto novoProduto = new Produto();
        novoProduto.setNome("Produto Sem Preço");
        novoProduto.setDescricao("Descricao do Produto Sem Preço");
        novoProduto.setPreco(null);

        Long idproduto = produtoService.incluirProduto(novoProduto);
        assertNull(idproduto);
    }
    
    @Test
    void testIncluirProdutoSemNome() {
        System.out.println("teste de incluir produto sem Nome");
        Produto novoProduto = new Produto();
        novoProduto.setNome(null);
        novoProduto.setDescricao("Descricao do Produto Sem Nome");
        novoProduto.setPreco(1.90);

        Long idproduto = produtoService.incluirProduto(novoProduto);
        assertNull(idproduto);
    }
    
    @Test
    void testIncluirProdutoSemDescricao() {
        System.out.println("teste de incluir produto sem descricao");
        Produto novoProduto = new Produto();
        novoProduto.setNome("Produto Sem Descricao");
        novoProduto.setDescricao(null);
        novoProduto.setPreco(2.90);
        
        Long idproduto = produtoService.incluirProduto(novoProduto);
        assertNull(idproduto);
    }
}
