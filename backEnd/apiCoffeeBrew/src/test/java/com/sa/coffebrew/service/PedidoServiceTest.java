///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package com.sa.coffebrew.service;
//
//import com.sa.coffebrew.entity.Pedido;
//import java.util.List;
//import java.util.Optional;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author Pichau
// */
//public class PedidoServiceTest {
//    
//    public PedidoServiceTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    /**
//     * Test of incluirPedido method, of class PedidoService.
//     */
//    @Test
//    public void testIncluirPedido() {
//        System.out.println("incluirPedido");
//        Pedido pedido = null;
//        Long idProduto = null;
//        PedidoService instance = new PedidoService();
//        Long expResult = null;
//        Long result = instance.incluirPedido(pedido, idProduto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of excluirPedido method, of class PedidoService.
//     */
//    @Test
//    public void testExcluirPedido() {
//        System.out.println("excluirPedido");
//        Long idPedido = null;
//        PedidoService instance = new PedidoService();
//        Boolean expResult = null;
//        Boolean result = instance.excluirPedido(idPedido);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of consultarPedido method, of class PedidoService.
//     */
//    @Test
//    public void testConsultarPedido() {
//        System.out.println("consultarPedido");
//        Long idPedido = null;
//        PedidoService instance = new PedidoService();
//        Optional<Pedido> expResult = null;
//        Optional<Pedido> result = instance.consultarPedido(idPedido);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarPedidos method, of class PedidoService.
//     */
//    @Test
//    public void testListarPedidos() {
//        System.out.println("listarPedidos");
//        PedidoService instance = new PedidoService();
//        List<Pedido> expResult = null;
//        List<Pedido> result = instance.listarPedidos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of atualizarPedido method, of class PedidoService.
//     */
//    @Test
//    public void testAtualizarPedido() {
//        System.out.println("atualizarPedido");
//        Pedido pedido = null;
//        Long idProduto = null;
//        PedidoService instance = new PedidoService();
//        Boolean expResult = null;
//        Boolean result = instance.atualizarPedido(pedido, idProduto);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
