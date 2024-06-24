package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Cliente;
import com.sa.coffebrew.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    private Cliente cliente;
    
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setNome("aaa");
        cliente.setCelular(123456789L);
        cliente.setSenha("123");
        cliente.setCpf("987654321L");
        cliente.setEmail("teste@exemplo.com");
        clienteRepository.save(cliente);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    @Order(1)
    void testIncluirCliente() {
        System.out.println("teste de incluir cliente");
        Cliente novoCliente = new Cliente();
        novoCliente.setNome("aaa");
        novoCliente.setSenha("123");
        novoCliente.setCelular(123456780L);
        novoCliente.setCpf("987654320L");
        novoCliente.setEmail("a@exemplo.com");

        Long idCliente = clienteService.incluirCliente(novoCliente);
        assertNotNull(idCliente);

    }

    @Test
    @Order(2)
    void testConsultarCliente() {
        System.out.println("teste de consultar cliente por id");
        Optional<Cliente> result = clienteService.consultarCliente(cliente.getIdCliente());
        System.out.println(cliente.getIdCliente());
        assertTrue(result.isPresent());
    }
    

    @Test
    @Order(3)
    void testListarClientes() {
        System.out.println("teste de listar clientes");
        List<Cliente> result = clienteService.listarClientes();
        System.out.println(result);
        assertFalse(result.isEmpty());
    }

    @Test
    @Order(4)
    void testAtualizarCliente() {
        System.out.println("teste de atualizar cliente");
        cliente.setEmail("aaaa@exemplo.com");
        Boolean result = clienteService.atualizarCliente(cliente);
        assertTrue(result);
    }
    
    @Test
    @Order(5)
    void testExcluirCliente() {
        System.out.println("teste de excluircliente");
        Boolean result = clienteService.excluirCliente(cliente.getIdCliente());
        assertTrue(result);
    }
    
    @Test
    @Order(6)
    void testLoginCliente(){
        System.out.println("teste de login de cliente");
        Cliente result = clienteService.loginCliente("987654320L", "123456");
        assertNotNull(result);
        
    }
    @Test
    void testIncluirClienteSemCpf(){
    System.out.println("teste de incluir cliente sem cpf");
        Cliente novoClienteSemCpf = new Cliente();
        novoClienteSemCpf.setNome("aaa");
        novoClienteSemCpf.setSenha("123");
        novoClienteSemCpf.setCelular(123456780L);
        novoClienteSemCpf.setEmail("a@exemplo.com");
        novoClienteSemCpf.setCpf(null);
    
        Long idCliente = clienteService.incluirCliente(novoClienteSemCpf);
        Long expResult = null;
        assertEquals(expResult, idCliente);
    }

    @Test
    void testIncluirClienteComCpfComMaisDe11Digitos(){
    System.out.println("teste de incluir cliente com cpf com mais de 11 digitos");
        Cliente novoClienteComCpfGrande = new Cliente();
        novoClienteComCpfGrande.setNome("aaa");
        novoClienteComCpfGrande.setSenha("123");
        novoClienteComCpfGrande.setCelular(123456780L);
        novoClienteComCpfGrande.setEmail("a@exemplo.com");
        novoClienteComCpfGrande.setCpf("1234567891011");
    
        Long idCliente = clienteService.incluirCliente(novoClienteComCpfGrande);
        Long expResult = null;
        assertEquals(expResult, idCliente);
    }

    @Test
    void testIncluirClienteComCpfComMenosDe11Digitos(){
    System.out.println("teste de incluir cliente com cpf com menos de 11 digitos");
        Cliente novoClienteComCpfPequeno = new Cliente();
        novoClienteComCpfPequeno.setNome("aaa");
        novoClienteComCpfPequeno.setSenha("123");
        novoClienteComCpfPequeno.setCelular(123456780L);
        novoClienteComCpfPequeno.setEmail("a@exemplo.com");
        novoClienteComCpfPequeno.setCpf("1234567891011");
    
        Long idCliente = clienteService.incluirCliente(novoClienteComCpfPequeno);
        Long expResult = null;
        assertEquals(expResult, idCliente);
    }
    
    @Test
    void testIncluirClienteSemNome(){
    System.out.println("teste de incluir cliente sem nome");
        Cliente novoClienteSemNome = new Cliente();
        novoClienteSemNome.setNome(null);
        novoClienteSemNome.setSenha("123");
        novoClienteSemNome.setCelular(123456780L);
        novoClienteSemNome.setEmail("a@exemplo.com");
        novoClienteSemNome.setCpf("aaa");
    
        Long idCliente = clienteService.incluirCliente(novoClienteSemNome);
        Long expResult = null;
        assertEquals(expResult, idCliente);
    }
    
    @Test
    void testIncluirClienteSemEmail(){
    System.out.println("teste de incluir cliente sem cpf");
        Cliente novoClienteSemEmail = new Cliente();
        novoClienteSemEmail.setNome("a");
        novoClienteSemEmail.setSenha("123");
        novoClienteSemEmail.setCelular(123456780L);
        novoClienteSemEmail.setEmail(null);
        novoClienteSemEmail.setCpf("aaa");
    
        Long idCliente = clienteService.incluirCliente(novoClienteSemEmail);
        Long expResult = null;
        assertEquals(expResult, idCliente);
    }
    
    @Test
    void testIncluirClienteSemSenha(){
    System.out.println("teste de incluir cliente sem cpf");
        Cliente novoClienteSemSenha = new Cliente();
        novoClienteSemSenha.setNome("aaa");
        novoClienteSemSenha.setSenha(null);
        novoClienteSemSenha.setCelular(123456780L);
        novoClienteSemSenha.setEmail("a@exemplo.com");
        novoClienteSemSenha.setCpf("aa");
    
        Long idCliente = clienteService.incluirCliente(novoClienteSemSenha);
        Long expResult = null;
        assertEquals(expResult, idCliente);
    }
    
    @Test
    void testIncluirClienteSemCelular(){
    System.out.println("teste de incluir cliente sem cpf");
        Cliente novoClienteSemCelular = new Cliente();
        novoClienteSemCelular.setNome("aaa");
        novoClienteSemCelular.setSenha("123");
        novoClienteSemCelular.setCelular(null);
        novoClienteSemCelular.setEmail("a@exemplo.com");
        novoClienteSemCelular.setCpf("aaa");
    
        Long idCliente = clienteService.incluirCliente(novoClienteSemCelular);
        Long expResult = null;
        assertEquals(expResult, idCliente);
    }
}