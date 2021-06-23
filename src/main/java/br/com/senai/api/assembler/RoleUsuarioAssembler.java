package br.com.senai.api.assembler;

import br.com.senai.api.model.RoleUsuarioDTO;
import br.com.senai.domain.model.RoleUsuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class RoleUsuarioAssembler {

    private ModelMapper modelMapper;

    public RoleUsuario toEntity(RoleUsuarioDTO roleUsuarioDTO){
        return modelMapper.map(roleUsuarioDTO, RoleUsuario.class);
    }

    public RoleUsuarioDTO toModel(RoleUsuario roleUsuario){
        return modelMapper.map(roleUsuario, RoleUsuarioDTO.class);
    }


}
