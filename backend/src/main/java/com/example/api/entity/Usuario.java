package com.example.api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "saldo", nullable = false)
    private Double saldo;

    // Constructors
    public Usuario() {
    }

    public Usuario(String nome, Double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }

    // Getters and Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
