package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Funcionario;
import com.sa.coffebrew.repository.FuncionarioRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FuncionarioServiceTest {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private Funcionario funcionario;

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        funcionario = new Funcionario();
        funcionario.setPerfil("ADMIN");
        funcionario.setNome("aaa");
        funcionario.setCpf("12345678900");
        funcionario.setEmail("aaa@exemplo.com");

        funcionarioRepository.save(funcionario);
    }

    @AfterEach
    public void tearDown() {
        funcionarioRepository.deleteAll();
    }

    @Test
    @Order(1)
    public void testIncluirFuncionario() {
        System.out.println("teste de incluir funcionario");
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setPerfil("USER");
        novoFuncionario.setNome("bbb");
        novoFuncionario.setCpf("09876543210");
        novoFuncionario.setEmail("bbb@exemplo.com");

        Long idFuncionario = funcionarioService.incluirFuncionario(novoFuncionario);
        assertNotNull(idFuncionario);
    }

    @Test
    @Order(2)
    public void testConsultarFuncionario() {
        System.out.println("teste de consultar funcionario por id");
        Optional<Funcionario> result = funcionarioService.consultarFuncionario(funcionario.getIdFuncionario());
        assertTrue(result.isPresent());
    }

    @Test
    @Order(3)
    public void testListarFuncionarios() {
        System.out.println("teste de listar funcionarios");
        List<Funcionario> result = funcionarioService.listarFuncionarios();
        assertFalse(result.isEmpty());
    }

    @Test
    @Order(4)
    public void testAtualizarFuncionario() {
        System.out.println("teste de atualizar funcionario");
        funcionario.setEmail("aaaa@exemplo.com");
        Boolean result = funcionarioService.atualizarFuncionario(funcionario);
        assertTrue(result);
    }

    @Test
    @Order(5)
    public void testExcluirFuncionario() {
        System.out.println("teste de excluir funcionario");
        Boolean result = funcionarioService.excluirFuncionario(funcionario.getIdFuncionario());
        assertTrue(result);
    }


    @Test
    @Order(6)
    public void testIncluirFuncionarioSemCpf() {
        System.out.println("teste de incluir funcionario sem cpf");
        Funcionario novoFuncionarioSemCpf = new Funcionario();
        novoFuncionarioSemCpf.setPerfil("USER");
        novoFuncionarioSemCpf.setNome("ccc");
        novoFuncionarioSemCpf.setEmail("ccc@exemplo.com");

        Long idFuncionario = funcionarioService.incluirFuncionario(novoFuncionarioSemCpf);
        Long expResult = null;
        assertEquals(expResult, idFuncionario);
    }

    @Test
    @Order(7)
    public void testIncluirFuncionarioSemNome() {
        System.out.println("teste de incluir funcionario sem nome");
        Funcionario novoFuncionarioSemNome = new Funcionario();
        novoFuncionarioSemNome.setPerfil("USER");
        novoFuncionarioSemNome.setCpf("09876543211");
        novoFuncionarioSemNome.setEmail("ddd@exemplo.com");

        Long idFuncionario = funcionarioService.incluirFuncionario(novoFuncionarioSemNome);
        Long expResult = null;
        assertEquals(expResult, idFuncionario);
    }

    @Test
    @Order(8)
    public void testIncluirFuncionarioSemEmail() {
        System.out.println("teste de incluir funcionario sem email");
        Funcionario novoFuncionarioSemEmail = new Funcionario();
        novoFuncionarioSemEmail.setPerfil("USER");
        novoFuncionarioSemEmail.setNome("eee");
        novoFuncionarioSemEmail.setCpf("09876543212");

        Long idFuncionario = funcionarioService.incluirFuncionario(novoFuncionarioSemEmail);
        Long expResult = null;
        assertEquals(expResult, idFuncionario);
    }

    @Test
    @Order(9)
    public void testIncluirFuncionarioSemPerfil() {
        System.out.println("teste de incluir funcionario sem perfil");
        Funcionario novoFuncionarioSemPerfil = new Funcionario();
        novoFuncionarioSemPerfil.setNome("fff");
        novoFuncionarioSemPerfil.setCpf("09876543213");
        novoFuncionarioSemPerfil.setEmail("fff@exemplo.com");

        Long idFuncionario = funcionarioService.incluirFuncionario(novoFuncionarioSemPerfil);
        Long expResult = null;
        assertEquals(expResult, idFuncionario);
    }
    @Test
    void testIncluirFuncionarioComCpfComMaisDe11Digitos(){
    System.out.println("teste de incluir cliente com cpf com mais de 11 digitos");
        Funcionario novoFuncionarioComCpfGrande = new Funcionario();
        novoFuncionarioComCpfGrande.setNome("aaa");
        novoFuncionarioComCpfGrande.setEmail("a@exemplo.com");
        novoFuncionarioComCpfGrande.setCpf("1234567891011");
    
        Long idFuncionario = funcionarioService.incluirFuncionario(novoFuncionarioComCpfGrande);
        Long expResult = null;
        assertEquals(expResult, idFuncionario);
    }

    @Test
    void testIncluirFuncionarioComCpfComMenosDe11Digitos(){
    System.out.println("teste de incluir cliente com cpf com menos de 11 digitos");
        Funcionario novoFuncionarioComCpfPequeno = new Funcionario();
        novoFuncionarioComCpfPequeno.setNome("aaa");
        novoFuncionarioComCpfPequeno.setEmail("a@exemplo.com");
        novoFuncionarioComCpfPequeno.setCpf("123456789");
    
        Long idFuncionario = funcionarioService.incluirFuncionario(novoFuncionarioComCpfPequeno);
        Long expResult = null;
        assertEquals(expResult, idFuncionario);
    }
}
