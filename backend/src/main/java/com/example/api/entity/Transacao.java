package com.example.api.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_transacoes") // isso defini o nome da tabela
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// chave primaria
    private Long id;

    private java.time.LocalDate data;

    @ManyToOne
    @JoinColumn(name="tipos", nullable = false )// nomeio a coluna e dou caracteristicas a elas.
    // cria uma coluna na tabela de transacoes que contem a FK de tipos
    private Tipo tipoTransacao;

    @Column(name= "valor", nullable = false)
    private Double valor;

    // Constructors
    public Transacao() {
    }

    public Transacao(Tipo tipoTransacao, Double valor) {
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(Tipo tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
