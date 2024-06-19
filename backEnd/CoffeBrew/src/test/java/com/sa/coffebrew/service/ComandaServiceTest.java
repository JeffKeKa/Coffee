///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package com.sa.coffebrew.service;
//
//import com.sa.coffebrew.entity.Comanda;
//import com.sa.coffebrew.repository.ComandaRepository;
//import java.util.List;
//import java.util.Optional;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
///**
// *
// * @author Pichau
// */
//@SpringBootTest
//public class ComandaServiceTest {
//    
//    @Autowired
//    private ComandaService comandaService;
//
//    @Autowired
//    private ComandaRepository comandaRepository;
//
//    private Comanda comanda;
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
//        Comanda novaComanda = new Comanda();
//        novaComanda.setPrecoTotal(150.0);
//        novaComanda.setStatus("ATIVO");
//        novaComanda.setnComanda(124);
//
//        Comanda comandaSalva = comandaService.incluirComanda(novaComanda);
//        assertNotNull(comandaSalva.getIdComanda());
//    }
//
//}
