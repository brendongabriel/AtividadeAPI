package br.com.senai.domain.service;

import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.PessoaModel;
import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaAssembler pessoaAssembler;

    @Transactional
    public Pessoa cadastrar(Pessoa pessoa){
        boolean emailValidation = pessoaRepository.findByEmail(
                pessoa.getEmail()).isPresent();
        if (emailValidation){
            throw new NegocioException(
                    "Ja existe uma  pessoa com esse e-mail cadastrado.");
        }

        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public void deletar(Long pessoaId){
        pessoaRepository.deleteById(pessoaId);
    }

    public Pessoa buscar(Long pessoaId){
        return pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new NegocioException("Pessoa não encontrada."));
    }

    public List<PessoaModel> listar(){
        return pessoaAssembler.toCollectionModel(pessoaRepository.findAll());
    }

//    public List<PessoaModel> buscarNome(String nome){
//        return pessoaRepository.findByNome(nome).stream().
//                map(pessoa -> {
//                    return ResponseEntity.ok(pessoaAssembler.toModel(pessoa));
//                })
//    }
}
