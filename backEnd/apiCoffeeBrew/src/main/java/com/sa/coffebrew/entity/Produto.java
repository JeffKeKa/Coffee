package com.sa.coffebrew.entity;

import jakarta.persistence.*;

@Table(name = "produtos")
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long idProduto;
    
    @Column(nullable = false)
    private String nome;
    
    @Column(nullable = false)
    private Double preco;
    
    @Column(nullable = false)
    private String descricao;
    
    @Column(nullable = true)
    private String imgURL;

    public String getImgURL() {
        return imgURL;
    }
    
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
    
}
