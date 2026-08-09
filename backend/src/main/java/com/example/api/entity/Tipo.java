package com.example.api.entity;
// oque é um enum, são classes com valores estaticos e fixos onde eles recebem de maneiro rigida o valor literal da variavel.


import jakarta.persistence.*;
@Entity
@Table(name = "tipos")
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", unique = true, nullable = false, length = 100)
    private String nome;

    public Tipo(String nome) {
        this.nome = nome;
    }

    public Tipo(){ }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}
