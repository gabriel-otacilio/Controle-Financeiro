package com.example.api.services;

import com.example.api.entity.Tipo;
import com.example.api.entity.Transacao;
import com.example.api.repository.TipoRepository;
import com.example.api.repository.TransacaoRepository;
import com.example.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
// aqui vao tudo que o usuario vai fazer
    private final UsuarioRepository usuarioRepository;
    private final TransacaoRepository transacaoRepository;
    private final TipoRepository tipoRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, TransacaoRepository transacaoRepository, TipoRepository tipoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.transacaoRepository = transacaoRepository;
        this.tipoRepository = tipoRepository;
    }


    @Transactional
    // necessario quando for fazer alguma mudança no banco

    public Transacao FazerTransacao(Double valor, Tipo tipoTransacao){
        // valido as entradas
        if (tipoTransacao == null || valor == null){
            throw new IllegalArgumentException("tipo de transação ou valor nao válidos");
        }

        Transacao transacao = new Transacao(tipoTransacao, valor);
        transacaoRepository.save(transacao);
        System.out.println("transação feita com sucesso");
        // crio e salvo a transação
        return transacao;
    }


    public List<Transacao> consultarHistorico(Long id_usuario){
        return transacaoRepository.findByUsuario_id(id_usuario);
    }

    @Transactional
    public Tipo criarTipo(String nome){
        if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("nome inválido");
        }

        Tipo tipo = new Tipo(nome);
        tipoRepository.save(tipo);
        System.out.println("Tipo criado com sucesso");
        return tipo;
    }

    public List<Tipo> consultarTipos(){
        return tipoRepository.findAll();
    }

    // consultar gastos por tipo
    public List<Transacao> consultarGastosPorTipo(Long id_usuario, Long tipo_id){
        return transacaoRepository.findByTipo_id(tipo_id);
    }

    // filtrar gastos por valor

}
