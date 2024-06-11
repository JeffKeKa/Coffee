package com.sa.coffebrew.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Table(name = "pedidos")
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long idPedido;
    
    @Column(nullable = false)
    private Integer quantidade;
    
    @Column(nullable = false)
    private Double precoPedido;
    
    @Column(nullable = false)
    private String statusPedido;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(nullable = false)
    private Comanda comanda;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto; 

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoPedido() {
        return precoPedido;
    }

    public void setPrecoPedido(Double precoPedido) {
        this.precoPedido = precoPedido;
    }

    public Comanda getComanda() {
        return comanda;
    }

    public void setComanda(Comanda comanda) {
        this.comanda = comanda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }
    
}
