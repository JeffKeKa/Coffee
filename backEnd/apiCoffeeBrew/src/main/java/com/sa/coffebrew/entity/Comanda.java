package com.sa.coffebrew.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Table(name = "comandas")
@Entity
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long idComanda;
    
    @Column(nullable = false)
    private Double precoTotal;
    
    @Column(nullable = false)
    private String status;
    
    @Column(nullable = false)
    private Integer nComanda;
    
    @ManyToOne
    @JsonBackReference
    @JoinColumn(nullable = true)
    private Cliente cliente;
    
    @OneToMany(mappedBy = "comanda", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Pedido> pedidos;

    public Integer getnComanda() {
        return nComanda;
    }

    public Long getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Long idComanda) {
        this.idComanda = idComanda;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setnComanda(Integer nComanda) {
        this.nComanda = nComanda;
    }
    
}
