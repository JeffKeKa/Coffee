//package com.sa.coffebrew.service;
//
//import com.sa.coffebrew.entity.Produto;
//import com.sa.coffebrew.repository.ProdutoRepository;
//import com.sa.coffebrew.service.ProdutoService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ProdutoServiceTest {
//
//    @Autowired
//    private ProdutoService produtoService;
//
//    @Autowired
//    private ProdutoRepository produtoRepository;
//
//    private Produto produto;
//
//    @BeforeEach
//    void setUp() {
//        produto = new Produto();
//        produto.setNome("Produto Teste");
//        produto.setPreco(10.0);
//        produto.setDescricao("Descrição do Produto Teste");
//        produtoRepository.save(produto);
//    }
//
//    @Test
//    void testIncluirProduto() {
//        Produto newProduto = new Produto();
//        newProduto.setNome("Novo Produto");
//        newProduto.setPreco(15.0);
//        newProduto.setDescricao("Descrição do Novo Produto");
//
//        Long idProduto = produtoService.incluirProduto(newProduto);
//        assertNotNull(idProduto);
//
//        Optional<Produto> foundProduto = produtoRepository.findById(idProduto);
//        assertTrue(foundProduto.isPresent());
//    }
//
//    @Test
//    void testExcluirProduto() {
//        Boolean result = produtoService.excluirProduto(produto.getIdProduto());
//        assertTrue(result);
//
//        Optional<Produto> foundProduto = produtoRepository.findById(produto.getIdProduto());
//        assertFalse(foundProduto.isPresent());
//    }
//
//    @Test
//    void testConsultarProduto() {
//        Optional<Produto> result = produtoService.consultarProduto(produto.getIdProduto());
//        assertTrue(result.isPresent());
//    }
//
//    @Test
//    void testListarProdutos() {
//        List<Produto> result = produtoService.listarProdutos();
//        assertFalse(result.isEmpty());
//    }
//
//    @Test
//    void testAtualizarProduto() {
//        produto.setDescricao("Descrição Atualizada");
//        Boolean result = produtoService.atualizarProduto(produto);
//        assertTrue(result);
//
//        Optional<Produto> updatedProduto = produtoRepository.findById(produto.getIdProduto());
//        assertTrue(updatedProduto.isPresent());
//        assertEquals("Descrição Atualizada", updatedProduto.get().getDescricao());
//    }
//}
