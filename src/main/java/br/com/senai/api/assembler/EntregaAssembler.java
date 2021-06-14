package br.com.senai.api.assembler;

import br.com.senai.api.model.EntregaModel;
import br.com.senai.api.model.input.EntregaInput;
import br.com.senai.domain.model.Entrega;
import br.com.senai.domain.repository.EntregaRopository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaAssembler {

    private ModelMapper modelMapper;
    private EntregaRopository entregaRopository;


    public EntregaModel toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaModel.class);
    }

    public List<EntregaModel> toColletionModel(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }
}
