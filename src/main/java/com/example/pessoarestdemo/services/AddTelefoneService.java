package com.example.pessoarestdemo.services;

import com.example.pessoarestdemo.entities.Pessoa;
import com.example.pessoarestdemo.entities.Telefone;
import com.example.pessoarestdemo.repositories.TelefoneRepository;
import com.example.pessoarestdemo.tos.TelefoneTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Objects;

@Service
public class AddTelefoneService {
    @Autowired
    private TelefoneRepository telefoneRepository;

    public Pessoa execute(List<TelefoneTO> telefones, Pessoa pessoa){

        if(Objects.nonNull(telefones) && !telefones.isEmpty()) {
            Flux.fromIterable(telefones)
                    .flatMap(telefoneTO -> createTelefone(telefoneTO, pessoa.getId()))
                    .flatMap(telefoneRepository::save).subscribe();

        }
        return pessoa;
    }

    private  Flux<Telefone> createTelefone(TelefoneTO telefoneTO, Long id) {
        Telefone telefone = new Telefone();
        telefone.setNumero(telefoneTO.getNumero());
        telefone.setIdPessoa(id);
        return Flux.just(telefone);
    }
}
