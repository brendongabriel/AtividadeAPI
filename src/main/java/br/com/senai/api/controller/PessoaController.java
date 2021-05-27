package br.com.senai.api.controller;

import br.com.senai.domain.model.Pessoa;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PessoaController {


    @GetMapping("/pessoas")
    public List listar(){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Brendin");
        pessoa.setEmail("brendon_g_silva@estudante.sc.senai.br");
        pessoa.setTelefone("(47) 90000-0000");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setId(2L);
        pessoa2.setNome("Jhonis");
        pessoa2.setEmail("Jhonis.gmail.com");
        pessoa2.setTelefone("(47) 90000-0000");

        return Arrays.asList(pessoa,pessoa2);
    }
}
