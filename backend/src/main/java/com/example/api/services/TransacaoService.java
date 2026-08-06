package com.example.api.services;

import com.example.api.entity.Transacao;
import com.example.api.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TransacaoService {

    // Declaração do repositorio
    private final TransacaoRepository transacaoRepository;

    // Aqui o Spring injeta o repositorio
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }


}
