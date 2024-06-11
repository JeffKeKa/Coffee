//package com.sa.coffebrew.service;
//
//import com.sa.coffebrew.entity.Cliente;
//import com.sa.coffebrew.repository.ClienteRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//import java.util.Optional;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.TestMethodOrder;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class ClienteServiceTest {
//
//    @Autowired
//    private ClienteService clienteService;
//
//    @Autowired
//    private ClienteRepository clienteRepository;
//
//    private Cliente cliente;
//    
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
//    void setUp() {
//        cliente = new Cliente();
//        cliente.setCelular(123456789L);
//        cliente.setCpf("987654321L");
//        cliente.setEmail("teste@exemplo.com");
//        clienteRepository.save(cliente);
//    }
//    @AfterEach
//    public void tearDown() {
//    }
//
//    @Test
//    @Order(1)
//    void testIncluirCliente() {
//        Cliente novoCliente = new Cliente();
//        novoCliente.setCelular(123456780L);
//        novoCliente.setCpf("987654320L");
//        novoCliente.setEmail("a@exemplo.com");
//
//        Long idCliente = clienteService.incluirCliente(novoCliente);
//        assertNotNull(idCliente);
//
//    }
//
//    @Test
//    @Order(2)
//    void testConsultarCliente() {
//        Optional<Cliente> result = clienteService.consultarCliente(cliente.getIdCliente());
//        System.out.println(cliente.getIdCliente());
//        assertTrue(result.isPresent());
//    }
//    
//
//    @Test
//    @Order(3)
//    void testListarClientes() {
//        List<Cliente> result = clienteService.listarClientes();
//        System.out.println(result);
//        assertFalse(result.isEmpty());
//    }
//
//    @Test
//    @Order(4)
//    void testAtualizarCliente() {
//        cliente.setEmail("updated@example.com");
//        Boolean result = clienteService.atualizarCliente(cliente);
//        assertTrue(result);
//    }
//    
//    @Test
//    @Order(5)
//    void testExcluirCliente() {
//        
//        Boolean result = clienteService.excluirCliente(cliente.getIdCliente());
//        assertTrue(result);
//    }
//}