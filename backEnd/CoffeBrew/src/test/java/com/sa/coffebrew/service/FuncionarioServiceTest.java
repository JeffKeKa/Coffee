//package com.sa.coffebrew.service;
//
//import com.sa.coffebrew.entity.Funcionario;
//import com.sa.coffebrew.repository.FuncionarioRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.TestMethodOrder;
//
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class FuncionarioServiceTest {
//
//    @Autowired
//    private FuncionarioService funcionarioService;
//
//    @Autowired
//    private FuncionarioRepository funcionarioRepository;
//
//    private Funcionario funcionario;
//
//    @BeforeEach
//    void setUp() {
//        funcionario = new Funcionario();
//        funcionario.setPerfil("gerente");
//        funcionario.setNome("John Doe");
//        funcionario.setCpf("12345678900");
//        funcionario.setEmail("john.doe@example.com");
//        funcionarioRepository.save(funcionario);
//    }
//
//    @Test
//    @Order(1)
//    void testIncluirFuncionario() {
//        Funcionario newFuncionario = new Funcionario();
//        newFuncionario.setPerfil("gerente");
//        newFuncionario.setNome("Jane Doe");
//        newFuncionario.setCpf("09876543210");
//        newFuncionario.setEmail("jane.doe@example.com");
//
//        Long idFuncionario = funcionarioService.incluirFuncionario(newFuncionario);
//        assertNotNull(idFuncionario);
//
//    }
//
//    @Test
//    @Order(2)
//    void testExcluirFuncionario() {
//        Boolean result = funcionarioService.excluirFuncionario(funcionario.getIdFuncionario());
//        assertTrue(result);
//
//        
//    }
//
//    @Test
//    @Order(3)
//    void testConsultarFuncionario() {
//        Optional<Funcionario> result = funcionarioService.consultarFuncionario(funcionario.getIdFuncionario());
//        assertTrue(result.isPresent());
//    }
//
//    @Test
//    @Order(4)
//    void testListarFuncionarios() {
//        List<Funcionario> result = funcionarioService.listarFuncionarios();
//        assertFalse(result.isEmpty());
//    }
//
//    @Test
//    @Order(5)
//    void testAtualizarFuncionario() {
//        funcionario.setEmail("updated.john.doe@example.com");
//        Boolean result = funcionarioService.atualizarFuncionario(funcionario);
//        assertTrue(result);
//    }
//}
