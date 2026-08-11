package com.example.api.dto;

import java.time.LocalDateTime;

public class TransacaoDTO {
    public Double valor;
    public String nomeTipo;

    public TransacaoDTO(Double valor, String nomeTipo)
    {
        this.valor = valor;
        this.nomeTipo = nomeTipo;
    }
}
