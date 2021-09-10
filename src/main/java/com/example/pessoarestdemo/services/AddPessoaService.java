package com.example.pessoarestdemo.services;

import com.example.pessoarestdemo.entities.Pessoa;
import com.example.pessoarestdemo.repositories.PessoaRepository;
import com.example.pessoarestdemo.repositories.TelefoneRepository;
import com.example.pessoarestdemo.tos.PessoaRequest;
import com.example.pessoarestdemo.tos.PessoaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AddPessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private AddTelefoneService addTelefoneService;

    private PessoaRequest pessoaRequest;

    public Mono<PessoaResponse> insertPessoa(PessoaRequest pessoaRequest){
        this.pessoaRequest = pessoaRequest;
        Mono<Pessoa> pessoaM =  Mono.just(pessoaRequest).flatMap(this::generatePessoa)
                .flatMap(repository::save);

        return pessoaM.map(this::toPessoaResponse);

    }

    private  Mono<Pessoa> generatePessoa(PessoaRequest pessoaRequest) {
        Pessoa pessoa = new Pessoa();
        pessoa.setCep(pessoaRequest.getCep());
        pessoa.setComplemento(pessoaRequest.getComplemento());
        pessoa.setIdade(pessoaRequest.getIdade());
        pessoa.setNumero(pessoaRequest.getNumero());
        pessoa.setNome(pessoaRequest.getNome());
        return Mono.just(pessoa);
    }

    private PessoaResponse toPessoaResponse(Pessoa pessoa) {
        PessoaResponse pessoaResponse = PessoaResponse.from(pessoa);
        addTelefoneService.execute(pessoaRequest.getTelefones(),pessoa);
        return pessoaResponse;
    }
}
