package br.com.senai.api.assembler;

import br.com.senai.api.model.PessoaModel;
import br.com.senai.api.model.input.EntregaInput;
import br.com.senai.api.model.input.PessoaInput;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PessoaAssembler {

    private ModelMapper modelMapper;
    private PessoaRepository pessoaRepository;

    public Pessoa toEntity(PessoaInput pessoaInput){
        return modelMapper.map(pessoaInput, Pessoa.class);
    }

    public List<PessoaModel> toCollectionModel(List<Pessoa> pessoas) {
        return pessoas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public PessoaModel toModel(Pessoa pessoa){
        return modelMapper.map(pessoa, PessoaModel.class);
    }

}
