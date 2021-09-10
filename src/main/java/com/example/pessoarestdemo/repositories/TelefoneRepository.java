package com.example.pessoarestdemo.repositories;

import com.example.pessoarestdemo.entities.Telefone;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;


public interface TelefoneRepository extends ReactiveCrudRepository<Telefone,Long> {

    Flux<Telefone> findAllByIdPessoa(Long idPessoa);
}
