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
//        cliente.setNome("aaa");
//        cliente.setCelular(123456789L);
//        cliente.setSenha("123");
//        cliente.setCpf("987654321L");
//        cliente.setEmail("teste@exemplo.com");
//        clienteRepository.save(cliente);
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    @Test
//    @Order(1)
//    void testIncluirCliente() {
//        Cliente novoCliente = new Cliente();
//        novoCliente.setNome("aaa");
//        novoCliente.setSenha("123");
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
//        cliente.setEmail("aaaa@exemplo.com");
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
//    
//    @Test
//    @Order(6)
//    void testLoginCliente(){
////        Cliente novoCliente = new Cliente();
////        novoCliente.setNome("bbbb");
////        novoCliente.setSenha("123456");
////        novoCliente.setCelular(123456780L);
////        novoCliente.setCpf("987654320L");
////        novoCliente.setEmail("bbbbbb@exemplo.com");
////        Long idCliente = clienteService.incluirCliente(novoCliente);
////        assertNotNull(idCliente);
//        Cliente result = clienteService.loginCliente("987654320L", "123456");
//        assertNotNull(result);
//        
//    }
//}