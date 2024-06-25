package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Comanda;
import com.sa.coffebrew.repository.ComandaRepository;
import com.sa.coffebrew.repository.PedidoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public Comanda incluirComanda(Comanda comanda) {
        
        if(comanda.getPrecoTotal() == null||
           comanda.getStatus() == null||
           comanda.getnComanda() == null)
        {
        return null;
        }else{
        Long idComanda = comandaRepository.save(comanda).getIdComanda();
        return comandaRepository.getReferenceById(idComanda);
        }
    }

    public Boolean excluirComanda(Long idComanda) {
        try {
            comandaRepository.deleteById(idComanda);
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao excluir Comanda ID: " + idComanda + " Erro: " + ex.getLocalizedMessage());
            return false;
        }
    }

    public Comanda IncluirComandaPorNumero(Integer nComanda) {
        Optional<Comanda> pesquisa = comandaRepository.findActiveComandaByNumero(nComanda);

        if (pesquisa.isPresent()) {
            return pesquisa.get();
        } else {
            Comanda comanda = new Comanda();
            comanda.setnComanda(nComanda);
            comanda.setStatus("ATIVO");
            comanda.setPrecoTotal(1.90);
            Comanda ComandaFront = incluirComanda(comanda);
            return ComandaFront;
        }
    }

    public Optional<Comanda> consultarComanda(Long idComanda) {
        return comandaRepository.findById(idComanda);
    }

    public Comanda consultarComandaPorNumero(Integer nComanda) {

        Optional<Comanda> comanda = comandaRepository.findActiveComandaByNumero(nComanda);

        if (comanda.isPresent()) {

            return comanda.get();
        } else {
            return null;
        }

    }

    public List<Comanda> listarComanda() {
        return comandaRepository.findAll();
    }

    public Boolean atualizarComanda(Comanda comanda) {
        Optional<Comanda> optionalComanda = comandaRepository.findById(comanda.getIdComanda());
        if (optionalComanda.isPresent()) {
            Comanda c = optionalComanda.get();
            c.setPrecoTotal(comanda.getPrecoTotal());
            c.setStatus(comanda.getStatus());
            c.setCliente(comanda.getCliente());
            c.setnComanda(comanda.getnComanda());
            comandaRepository.save(c);
            return true;
        } else {
            return false;
        }
    }
}
