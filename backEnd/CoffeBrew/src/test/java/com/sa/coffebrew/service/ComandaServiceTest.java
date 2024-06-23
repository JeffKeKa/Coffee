package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Comanda;
import com.sa.coffebrew.repository.ComandaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ComandaServiceTest {

    @Autowired
    private ComandaService comandaService;

    @Autowired
    private ComandaRepository comandaRepository;

    private Comanda comanda;

    @BeforeEach
    public void setUp() {
        comanda = new Comanda();
        comanda.setPrecoTotal(200.0);
        comanda.setStatus("ATIVO");
        comanda.setnComanda(101);
    }

    

    @Test
    public void testIncluirComanda() {
        Comanda comandaSalva = comandaService.incluirComanda(comanda);
        assertNotNull(comandaSalva.getIdComanda());
    }

    @Test
    public void testExcluirComanda() {
        Comanda comandaSalva = comandaService.incluirComanda(comanda);
        Long idComanda = comandaSalva.getIdComanda();
        Boolean isDeleted = comandaService.excluirComanda(idComanda);
        assertTrue(isDeleted);
        assertFalse(comandaRepository.findById(idComanda).isPresent());
    }

    @Test
    public void testIncluirComandaPorNumero() {
        Comanda comandaSalva = comandaService.IncluirComandaPorNumero(102);
        assertNotNull(comandaSalva.getIdComanda());
        assertEquals(102, comandaSalva.getnComanda());
        assertEquals("ATIVO", comandaSalva.getStatus());
    }

    @Test
    public void testConsultarComanda() {
        Comanda comandaSalva = comandaService.incluirComanda(comanda);
        Optional<Comanda> comandaConsultada = comandaService.consultarComanda(comandaSalva.getIdComanda());
        assertTrue(comandaConsultada.isPresent());
        assertEquals(comandaSalva.getIdComanda(), comandaConsultada.get().getIdComanda());
    }

    @Test
    public void testListarComanda() {
        comandaService.incluirComanda(comanda);
        assertFalse(comandaService.listarComanda().isEmpty());
    }

    @Test
    public void testAtualizarComanda() {
        Comanda comandaSalva = comandaService.incluirComanda(comanda);
        comandaSalva.setPrecoTotal(250.0);
        comandaSalva.setStatus("INATIVO");
        Boolean isUpdated = comandaService.atualizarComanda(comandaSalva);
        assertTrue(isUpdated);

        Optional<Comanda> comandaAtualizada = comandaService.consultarComanda(comandaSalva.getIdComanda());
        assertTrue(comandaAtualizada.isPresent());
        assertEquals(250.0, comandaAtualizada.get().getPrecoTotal());
        assertEquals("INATIVO", comandaAtualizada.get().getStatus());
    }
}
