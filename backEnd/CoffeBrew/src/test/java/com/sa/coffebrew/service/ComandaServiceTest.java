package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Comanda;
import com.sa.coffebrew.repository.ComandaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ComandaServiceTest {

    @Autowired
    private ComandaService comandaService;

    @Autowired
    private ComandaRepository comandaRepository;

    private Comanda comanda;
    
    
    public static int gerarNumeroDe3Digitos() {
    Random random = new Random();
    return random.nextInt(900) + 100; // Gera um número entre 100 e 999
}

    
    @BeforeEach
    public void setUp() {
        comanda = new Comanda();
        comanda.setPrecoTotal(200.0);
        comanda.setStatus("ATIVO");
        comanda.setnComanda(gerarNumeroDe3Digitos());
    }

    @Test
    public void testIncluirComanda() {
        System.out.println("teste de incluir comanda");
        Comanda comandaSalva = comandaService.incluirComanda(comanda);
        assertNotNull(comandaSalva.getIdComanda());
        
    }

    @Test
    public void testExcluirComanda() {
        System.out.println("teste de excluir comanda");
        Comanda comandaSalva = comandaService.incluirComanda(comanda);
        Long idComanda = comandaSalva.getIdComanda();
        Boolean isDeleted = comandaService.excluirComanda(idComanda);
        assertTrue(isDeleted);
        assertFalse(comandaRepository.findById(idComanda).isPresent());
        
    }

    @Test
    public void testIncluirComandaPorNumero() {
        System.out.println("teste de incluir comanda por numero");
        Comanda comandaSalva = comandaService.IncluirComandaPorNumero(102);
        assertNotNull(comandaSalva.getIdComanda());
        assertEquals(102, comandaSalva.getnComanda());
        assertEquals("ATIVO", comandaSalva.getStatus());
        
    }

    @Test
    public void testConsultarComanda() {
        System.out.println("teste de consultar comanda");
        Comanda comandaSalva = comandaService.incluirComanda(comanda);
        Optional<Comanda> comandaConsultada = comandaService.consultarComanda(comandaSalva.getIdComanda());
        assertTrue(comandaConsultada.isPresent());
        assertEquals(comandaSalva.getIdComanda(), comandaConsultada.get().getIdComanda());
        
    }

    @Test
    public void testListarComanda() {
        System.out.println("teste de listar comandas");
        comandaService.incluirComanda(comanda);
        assertFalse(comandaService.listarComanda().isEmpty());
        
    }

    @Test
    public void testAtualizarComanda() {
        System.out.println("teste de atualizar comanda");
        Optional<Comanda> optionalComanda = comandaService.consultarComanda(2L);
        Comanda comandaSalva = optionalComanda.get();
        comandaSalva.setPrecoTotal(250.0);
        comandaSalva.setStatus("INATIVO");
        Boolean comandaAtualizada = comandaService.atualizarComanda(comandaSalva);
        assertTrue(comandaAtualizada);

        
       
    }
}
