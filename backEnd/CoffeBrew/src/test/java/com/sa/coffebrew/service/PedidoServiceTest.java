//package com.sa.coffebrew.service;
//
//import com.sa.coffebrew.entity.Comanda;
//import com.sa.coffebrew.entity.Pedido;
//import com.sa.coffebrew.entity.PedidoFront;
//import com.sa.coffebrew.entity.Produto;
//import com.sa.coffebrew.repository.PedidoRepository;
//import com.sa.coffebrew.repository.ProdutoRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//public class PedidoServiceTest {
//
//    @Autowired
//    private PedidoService pedidoService;
//
//    @Autowired
//    private PedidoRepository pedidoRepository;
//
//    @Autowired
//    private ProdutoRepository produtoRepository;
//
//    private Pedido pedido;
//    private Produto produto;
//    private Comanda comanda;
//
//    @BeforeEach
//    public void setUp() {
//        produto = new Produto();
//        produto.setNome("Produto Teste");
//        produto.setPreco(100.0);
//        produto = produtoRepository.save(produto);
//
//        comanda = new Comanda();
//        comanda.setPrecoTotal(200.0);
//        comanda.setStatus("ATIVO");
//        comanda.setnComanda(101);
//        comanda = comandaService.incluirComanda(comanda);
//    }
//
//    @Test
//    public void testIncluirPedido() {
//        pedido = new Pedido();
//        pedido.setQuantidade(2);
//        pedido.setPrecoPedido(200.0);
//        pedido.setStatusPedido("PENDENTE");
//        pedido.setComanda(comanda);
//
//        Long idProduto = produto.getIdProduto();
//        Long idPedido = pedidoService.incluirPedido(pedido, idProduto);
//
//        assertNotNull(idPedido);
//        assertTrue(idPedido > 0);
//
//        Optional<Pedido> pedidoSalvo = pedidoService.consultarPedido(idPedido);
//        assertTrue(pedidoSalvo.isPresent());
//        assertEquals(2, pedidoSalvo.get().getQuantidade());
//        assertEquals(200.0, pedidoSalvo.get().getPrecoPedido());
//        assertEquals("PENDENTE", pedidoSalvo.get().getStatusPedido());
//        assertEquals(comanda.getIdComanda(), pedidoSalvo.get().getComanda().getIdComanda());
//        assertEquals(produto.getIdProduto(), pedidoSalvo.get().getProduto().getIdProduto());
//    }
//
//    @Test
//    public void testIncluirNovoPedido() {
//        PedidoFront pedidoFront = new PedidoFront();
//        pedidoFront.setQuantidade(3);
//        pedidoFront.setPrecoPedido(300.0);
//        pedidoFront.setStatusPedido("CONFIRMADO");
//        pedidoFront.setIdProduto(produto.getIdProduto());
//
//        List<PedidoFront> pedidos = new ArrayList<>();
//        pedidos.add(pedidoFront);
//
//        Boolean pedidoIncluido = pedidoService.incluirNovoPedido(pedidos, comanda.getnComanda());
//        assertTrue(pedidoIncluido);
//
//        List<Pedido> pedidosComanda = pedidoService.listarPedidos();
//        assertFalse(pedidosComanda.isEmpty());
//        assertEquals(1, pedidosComanda.size());
//
//        Pedido pedidoSalvo = pedidosComanda.get(0);
//        assertEquals(3, pedidoSalvo.getQuantidade());
//        assertEquals(300.0, pedidoSalvo.getPrecoPedido());
//        assertEquals("CONFIRMADO", pedidoSalvo.getStatusPedido());
//        assertEquals(comanda.getIdComanda(), pedidoSalvo.getComanda().getIdComanda());
//        assertEquals(produto.getIdProduto(), pedidoSalvo.getProduto().getIdProduto());
//    }
//
//    @Test
//    public void testExcluirPedido() {
//        pedido = new Pedido();
//        pedido.setQuantidade(2);
//        pedido.setPrecoPedido(200.0);
//        pedido.setStatusPedido("PENDENTE");
//        pedido.setComanda(comanda);
//
//        Long idProduto = produto.getIdProduto();
//        Long idPedido = pedidoService.incluirPedido(pedido, idProduto);
//
//        assertNotNull(idPedido);
//
//        Boolean pedidoExcluido = pedidoService.excluirPedido(idPedido);
//        assertTrue(pedidoExcluido);
//
//        Optional<Pedido> pedidoExcluidoConsulta = pedidoService.consultarPedido(idPedido);
//        assertFalse(pedidoExcluidoConsulta.isPresent());
//    }
//
//    @Test
//    public void testAtualizarPedido() {
//        pedido = new Pedido();
//        pedido.setQuantidade(2);
//        pedido.setPrecoPedido(200.0);
//        pedido.setStatusPedido("PENDENTE");
//        pedido.setComanda(comanda);
//
//        Long idProduto = produto.getIdProduto();
//        Long idPedido = pedidoService.incluirPedido(pedido, idProduto);
//
//        assertNotNull(idPedido);
//
//        pedido = pedidoService.consultarPedido(idPedido).orElseThrow();
//
//        pedido.setQuantidade(5);
//        pedido.setPrecoPedido(500.0);
//        pedido.setStatusPedido("CONFIRMADO");
//
//        Boolean pedidoAtualizado = pedidoService.atualizarPedido(pedido, idProduto);
//        assertTrue(pedidoAtualizado);
//
//        Pedido pedidoAtualizadoConsulta = pedidoService.consultarPedido(idPedido).orElseThrow();
//        assertEquals(5, pedidoAtualizadoConsulta.getQuantidade());
//        assertEquals(500.0, pedidoAtualizadoConsulta.getPrecoPedido());
//        assertEquals("CONFIRMADO", pedidoAtualizadoConsulta.getStatusPedido());
//    }
//}
