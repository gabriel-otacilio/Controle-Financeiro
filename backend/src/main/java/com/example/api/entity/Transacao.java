package com.example.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "tb_transacoes") // isso defini o nome da tabela
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// chave primaria
    private Long id;

    @Column(name = "data", nullable = false)
    private LocalDateTime data ;

    @ManyToOne
    @JoinColumn(name="tipo_id", nullable = false )// nomeio a coluna e dou caracteristicas a elas.
    // cria uma coluna na tabela transacoes com o id de tipos
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name="usuario_id", nullable = false )
    private Usuario usuario;

    @Column(name= "valor", nullable = false)
    private Double valor;

    // Constructors
    public Transacao() {
    }

    public Transacao(Tipo tipoTransacao, Double valor, Usuario usuario) {
        this.tipo = tipoTransacao;
        this.valor = valor;
        this.usuario = usuario;
        this.data = LocalDateTime.now();
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo_id) {
        this.tipo = tipo_id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
