//package com.sa.coffebrew.service;
//
//import com.sa.coffebrew.entity.Comanda;
//import com.sa.coffebrew.entity.Pedido;
//import com.sa.coffebrew.entity.Produto;
//import com.sa.coffebrew.repository.ComandaRepository;
//import com.sa.coffebrew.repository.PedidoRepository;
//import com.sa.coffebrew.repository.ProdutoRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class PedidoServiceTest {
//    @Autowired
//    private ComandaRepository comandaRepository; 
//    
//    @Autowired
//    private PedidoService pedidoService;
//    
//    @Autowired
//    private ProdutoService produtoService;
//
//    @Autowired
//    private ProdutoRepository produtoRepository;
//
//    @Autowired
//    private PedidoRepository pedidoRepository;
//    
//    private Comanda comanda;
//    private Produto produto1;
//    private Produto produto2;
//    
//    @Test
//    void testIncluirPedido() {
//        Optional<Comanda> optionalComanda = comandaRepository.findById(102L);
//        comanda = optionalComanda.get();
//        Pedido novoPedido = new Pedido();
//        novoPedido.setQuantidade(3);
//        novoPedido.setPrecoPedido(30.0);
//        novoPedido.setStatusPedido("NOVO");
//        novoPedido.setComanda(comanda);
//
//        Long idPedido = pedidoService.incluirPedido(novoPedido, 52L);
//        assertNotNull(idPedido);
//    }
//    @Test
//    void testIncluirNovoPedido() {
//        
//        Optional<Produto> optionalProduto1 = produtoRepository.findById(2L);
//        Optional<Produto> optionalProduto2 = produtoRepository.findById(52L);
//        
//        produto1 = optionalProduto1.get();
//        produto2 = optionalProduto2.get();
//        
//        Pedido pedido1 = new Pedido();
//        pedido1.setQuantidade(1);
//        pedido1.setPrecoPedido(10.0);
//        pedido1.setStatusPedido("NOVO");
//        pedido1.setProduto(produto2);
//
//        Pedido pedido2 = new Pedido();
//        pedido2.setQuantidade(2);
//        pedido2.setPrecoPedido(20.0);
//        pedido2.setStatusPedido("NOVO");
//        pedido2.setProduto(produto1);
//
//       List<Pedido> pedidos = Arrays.asList(pedido1, pedido2);
//       
//        Boolean result = pedidoService.incluirNovoPedido(pedidos, 124);
//        assertTrue(result);
//    }
//    
//    @Test
//    void testExcluirPedido() {
//        
//        Boolean result = pedidoService.excluirPedido(402L);
//        assertTrue(result);
//        
//    }
//    
//    @Test
//    void testConsultarPedido() {
//    
//        
//        
//    }
//
//}
