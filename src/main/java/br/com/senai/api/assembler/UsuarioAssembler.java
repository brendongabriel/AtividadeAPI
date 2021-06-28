package br.com.senai.api.assembler;

import br.com.senai.api.model.input.UsuarioInputDOT;
import br.com.senai.domain.model.Usuario;
import br.com.senai.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UsuarioAssembler {

    private ModelMapper modelMapper;
    private UsuarioRepository usuarioRepository;

    public Usuario toEntity(UsuarioInputDOT pessoaInputDTO){
        return modelMapper.map(pessoaInputDTO, Usuario.class);
    }

}

