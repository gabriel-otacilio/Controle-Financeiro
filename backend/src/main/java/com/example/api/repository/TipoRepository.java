package com.example.api.repository;

import com.example.api.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoRepository extends JpaRepository<Tipo, Long> {

    public Tipo findByNome(String nome);
}
