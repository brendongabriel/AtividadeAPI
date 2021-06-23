package br.com.senai.api.controller;

import br.com.senai.api.assembler.RoleUsuarioAssembler;
import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.RoleUsuario;
import br.com.senai.domain.repository.RoleUsuarioRepository;
import br.com.senai.domain.service.RoleUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class RoleUsuarioController {

    private RoleUsuarioRepository roleUsuarioRepository;
    private RoleUsuarioService roleUsuarioService;
    private RoleUsuarioAssembler roleUsuarioAssembler;

    @PostMapping("/role")
    public RoleUsuario cadastrarRoleUsuario(@Valid @PathVariable RoleUsuarioDTO roleUsuarioDTO){
        RoleUsuario roleUsuario = roleUsuarioService.cadastrar(roleUsuarioDTO);
        return roleUsuarioAssembler.toModel(roleUsuario);
    }
}
