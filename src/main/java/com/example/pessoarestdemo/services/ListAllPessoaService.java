package com.example.pessoarestdemo.services;

import com.example.pessoarestdemo.clients.ViaCep;
import com.example.pessoarestdemo.entities.Pessoa;
import com.example.pessoarestdemo.repositories.PessoaRepository;
import com.example.pessoarestdemo.tos.PessoaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
public class ListAllPessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ViaCep viaCep;

    @Autowired
    private PopulateTelefonePessoaService listTelefoneService;


    public Flux<PessoaResponse> execute() {
        return repository.findAll().map(this::toResponse);
    }

    private PessoaResponse toResponse(Pessoa pessoa) {
        PessoaResponse pessoaResponse= PessoaResponse.from(pessoa);

        if(Objects.nonNull(pessoa.getCep())){
            pessoaResponse.setAddress(viaCep.getCep(pessoaResponse.getCep()));
        }
        listTelefoneService.execute(pessoaResponse);

        return pessoaResponse;
    }
}
