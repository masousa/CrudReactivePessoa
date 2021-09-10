package com.example.pessoarestdemo.repositories;

import com.example.pessoarestdemo.entities.Pessoa;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PessoaRepository extends ReactiveCrudRepository<Pessoa,Long> {


}
