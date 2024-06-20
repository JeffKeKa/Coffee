package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Comanda;
import com.sa.coffebrew.entity.Pedido;
import com.sa.coffebrew.entity.PedidoFront;
import com.sa.coffebrew.entity.Produto;
import com.sa.coffebrew.repository.PedidoRepository;
import com.sa.coffebrew.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private ComandaService comandaService;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    public Long incluirPedido(Pedido pedido, Long idProduto) {

        pedido.setProduto(produtoRepository.getReferenceById(idProduto));
        return pedidoRepository.save(pedido).getIdPedido();

    }

    public Boolean incluirNovoPedido(List<PedidoFront> pedidoWeb, Integer nComanda) {

        try {
            Comanda comanda = comandaService.IncluirComandaPorNumero(nComanda);

            for (PedidoFront ped : pedidoWeb) {

                Pedido pedidoBD = new Pedido();
                pedidoBD.setComanda(comanda);
                pedidoBD.setPrecoPedido(ped.getPrecoPedido());
                pedidoBD.setQuantidade(ped.getQuantidade());
                pedidoBD.setStatusPedido(ped.getStatusPedido());
                Optional<Produto> prod = produtoService.consultarProduto(ped.getIdProduto());
                pedidoBD.setProduto(prod.get());
                pedidoRepository.save(pedidoBD);
            }
            return true;
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return false;
        }

    }

    public Boolean excluirPedido(Long idPedido) {
        try {
            pedidoRepository.deleteById(idPedido);
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao excluir pedido ID: " + idPedido + " Erro: " + ex.getLocalizedMessage());
            return false;
        }
    }

    public Optional<Pedido> consultarPedido(Long idPedido) {
        return pedidoRepository.findById(idPedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Boolean atualizarPedido(Pedido pedido, Long idProduto) {
        Pedido pedidoBD = pedidoRepository.getReferenceById(pedido.getIdPedido());

        if (pedidoBD != null) {
            pedido.setProduto(produtoRepository.getReferenceById(idProduto));
            pedidoBD.setStatusPedido(pedido.getStatusPedido());
            pedidoBD.setQuantidade(pedido.getQuantidade());
            pedidoBD.setPrecoPedido(pedido.getPrecoPedido());
            pedidoBD.setComanda(pedido.getComanda());
            pedidoBD.setProduto(pedido.getProduto());
            pedidoRepository.save(pedidoBD);
            return true;
        } else {
            return false;
        }
    }
}
