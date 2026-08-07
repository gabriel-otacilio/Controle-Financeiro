package com.example.api.controllers;

import com.example.api.dto.TransacaoDTO;
import com.example.api.dto.UsuarioDTO;
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

    @GetMapping("/usuarios")
    public List<Usuario> consultaUsuarios(){
        return usuarioService.consultarUsuarios();
    }

    @PostMapping("/faz_usuario")
    public void fazUsuario(@RequestBody UsuarioDTO usuarioDto){
        usuarioService.faz_usuario(usuarioDto);
    }

    @PostMapping("/{id}/transacao")
    public void fazTransacao(@RequestBody TransacaoDTO transacaoDto, @PathVariable Long id){
        usuarioService.FazerTransacao(transacaoDto,id);
    }
}
// eu recebo o id do usuario via url, o nome do tipo, e o valor