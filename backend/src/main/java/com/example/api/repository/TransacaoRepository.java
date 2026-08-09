package com.example.api.repository;

import com.example.api.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {// os parametros são assa entidade e o tipo da chave primaria


    public List <Transacao> findByValor(Double valor);
    // O spring ja converte automaticamente pra query necessaria

    public List<Transacao> findByUsuario_Id(Long id);

    public List<Transacao> findByTipo(Long id);




    // os nomes dos metodos devem ser iguais ao nome do atributo da entidade, não ao da coluna




}
