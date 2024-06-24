package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Funcionario;
import com.sa.coffebrew.repository.FuncionarioRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FuncionarioServiceTest {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    private Funcionario funcionario;

    @BeforeEach
    public void setUp() {
        funcionario = new Funcionario();
        funcionario.setPerfil("ADMIN");
        funcionario.setNome("aaa");
        funcionario.setCpf("12345678900");
        funcionario.setEmail("aaa@exemplo.com");
    }

    @AfterEach
    public void tearDown() {
       
    }

    @Test
    public void testIncluirFuncionario() {
        Long idFuncionario = funcionarioService.incluirFuncionario(funcionario);
        assertNotNull(idFuncionario);

        Optional<Funcionario> funcionarioSalvo = funcionarioRepository.findById(idFuncionario);
        assertTrue(funcionarioSalvo.isPresent());
        assertEquals("aaa", funcionarioSalvo.get().getNome());
    }

    @Test
    public void testExcluirFuncionario() {
        Long idFuncionario = funcionarioService.incluirFuncionario(funcionario);
        Boolean funcDeletado = funcionarioService.excluirFuncionario(idFuncionario);
        assertTrue(funcDeletado);
        assertFalse(funcionarioRepository.findById(idFuncionario).isPresent());
    }

    @Test
    public void testConsultarFuncionario() {
        Long idFuncionario = funcionarioService.incluirFuncionario(funcionario);
        Optional<Funcionario> funcionarioConsultado = funcionarioService.consultarFuncionario(idFuncionario);
        assertTrue(funcionarioConsultado.isPresent());
        assertEquals("aaa", funcionarioConsultado.get().getNome());
    }

    @Test
    public void testListarFuncionarios() {
        funcionarioService.incluirFuncionario(funcionario);
        assertFalse(funcionarioService.listarFuncionarios().isEmpty());
    }

    @Test
    public void testAtualizarFuncionario() {
        Long idFuncionario = funcionarioService.incluirFuncionario(funcionario);
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(idFuncionario);
        assertTrue(optionalFuncionario.isPresent());

        Funcionario funcionarioParaAtualizar = optionalFuncionario.get();
        funcionarioParaAtualizar.setNome("bbb");
        funcionarioParaAtualizar.setEmail("bbb@exemplo.com");

        Boolean funcionarioAtualizado = funcionarioService.atualizarFuncionario(funcionarioParaAtualizar);
        assertTrue(funcionarioAtualizado);

    }
}
