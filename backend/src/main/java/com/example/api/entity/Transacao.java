package com.example.api.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_transacoes") // isso defini o nome da tabela
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// chave primaria
    private Long id;

    @Column(name = "data", nullable = false)
    private java.time.LocalDate data;


    @ManyToOne
    @JoinColumn(name="tipo_id", nullable = false )// nomeio a coluna e dou caracteristicas a elas.
    // cria uma coluna na tabela transacoes com o id de tipos
    private Tipo tipo_id;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = false )
    private Usuario usuario_id;

    @Column(name= "valor", nullable = false)
    private Double valor;

    // Constructors
    public Transacao() {
    }

    public Transacao(Tipo tipoTransacao_id, Double valor) {
        this.tipo_id = tipoTransacao_id;
        this.valor = valor;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo_id() {
        return tipo_id;
    }

    public void setTipo_id(Tipo tipo_id) {
        this.tipo_id = tipo_id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

}
