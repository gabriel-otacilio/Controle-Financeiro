package com.example.api.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_transacoes") // isso defini o nome da tabela
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// chave primaria
    private Long id;

    @ManyToOne
    @JoinColumn(name="tipo_id", nullable = false )// nomeio a coluna e dou caracteristicas a elas.
    // cria uma coluna na tabela transacoes com o id de tipos
    private Tipo tipoId;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = false )
    private Usuario usuarioId;

    @Column(name= "valor", nullable = false)
    private Double valor;

    // Constructors
    public Transacao() {
    }

    public Transacao(Tipo tipoTransacao_id, Double valor, Usuario usuario_id) {
        this.tipoId = tipoTransacao_id;
        this.valor = valor;
        this.usuarioId = usuario_id;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo_id() {
        return tipoId;
    }

    public void setTipo_id(Tipo tipo_id) {
        this.tipoId = tipo_id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario_id() {
        return usuarioId;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuarioId = usuario_id;
    }

}
