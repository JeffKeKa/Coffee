package com.sa.coffebrew.entity;

public class PedidoFront {

    private Long idProduto;
    private Integer quantidade;
    private Double precoPedido;
    private String statusPedido;

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
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

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

}
