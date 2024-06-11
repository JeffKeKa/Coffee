///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package com.sa.coffebrew.service;
//
//import com.sa.coffebrew.entity.Comanda;
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
//public class ComandaServiceTest {
//    
//    public ComandaServiceTest() {
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
//     * Test of incluirComanda method, of class ComandaService.
//     */
//    @Test
//    public void testIncluirComanda() {
//        System.out.println("incluirComanda");
//        Comanda comanda = null;
//        Long idPedido = null;
//        ComandaService instance = new ComandaService();
//        Long expResult = null;
//        Long result = instance.incluirComanda(comanda, idPedido);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of excluirComanda method, of class ComandaService.
//     */
//    @Test
//    public void testExcluirComanda() {
//        System.out.println("excluirComanda");
//        Long idComanda = null;
//        ComandaService instance = new ComandaService();
//        Boolean expResult = null;
//        Boolean result = instance.excluirComanda(idComanda);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of consultarComanda method, of class ComandaService.
//     */
//    @Test
//    public void testConsultarComanda() {
//        System.out.println("consultarComanda");
//        Long idComanda = null;
//        ComandaService instance = new ComandaService();
//        Optional<Comanda> expResult = null;
//        Optional<Comanda> result = instance.consultarComanda(idComanda);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of listarComanda method, of class ComandaService.
//     */
//    @Test
//    public void testListarComanda() {
//        System.out.println("listarComanda");
//        ComandaService instance = new ComandaService();
//        List<Comanda> expResult = null;
//        List<Comanda> result = instance.listarComanda();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of atualizarComanda method, of class ComandaService.
//     */
//    @Test
//    public void testAtualizarComanda() {
//        System.out.println("atualizarComanda");
//        Comanda comanda = null;
//        ComandaService instance = new ComandaService();
//        Boolean expResult = null;
//        Boolean result = instance.atualizarComanda(comanda);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
