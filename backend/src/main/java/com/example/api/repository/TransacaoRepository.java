package com.example.api.repository;

import com.example.api.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {// os parametros são assa entidade e o tipo da chave primaria


    public Transacao findByValor(Double valor);
    // O spring ja converte automaticamente pra query necessaria




}
