package com.example.api.controllers;

import com.example.api.dto.TipoDTO;
import com.example.api.dto.TransacaoDTO;
import com.example.api.dto.UsuarioDTO;
import com.example.api.entity.Tipo;
import com.example.api.entity.Transacao;
import com.example.api.entity.Usuario;
import com.example.api.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    // primeira coisa é injetar a service
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioServiceP) {
        this.usuarioService = usuarioServiceP;
    }

    // funcional
    @GetMapping("/usuarios")
    public List<Usuario> consultaUsuarios(){
        return usuarioService.consultarUsuarios();
    }

    @GetMapping("/{id}/transacoes")
    public List<Transacao> consultaHistorico(@PathVariable Long id){
        return usuarioService.consultarHistorico(id);
    }

    // funcional
    @GetMapping("/tipos")
    public List<Tipo> consultaTipos(){
        return usuarioService.consultarTipos();
    }


// ----- POSTS -----

    // funcional
    @PostMapping("/faz_usuario")
    public void fazUsuario(@RequestBody UsuarioDTO usuarioDto){
        usuarioService.faz_usuario(usuarioDto);
    }
    // funcional
    @PostMapping("faz_tipo")
    public void fazTipo(@RequestBody TipoDTO tipoDto){
        usuarioService.criarTipo(tipoDto.nome);
    }

    @PostMapping("/{id}/faz_transacao")
    public void fazTransacao(@RequestBody TransacaoDTO transacaoDto, @PathVariable Long id){
        usuarioService.FazerTransacao(transacaoDto,id);
    }
}
// eu recebo o id do usuario via url, o nome do tipo, e o valor