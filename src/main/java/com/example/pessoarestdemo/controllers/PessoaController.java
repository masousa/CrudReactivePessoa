package com.example.pessoarestdemo.controllers;

import com.example.pessoarestdemo.services.AddPessoaService;
import com.example.pessoarestdemo.services.ListAllPessoaService;
import com.example.pessoarestdemo.tos.PessoaRequest;
import com.example.pessoarestdemo.tos.PessoaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private AddPessoaService addPessoaService;

    @Autowired
    private ListAllPessoaService listAllPessoaService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PessoaResponse> addPessoa(@RequestBody PessoaRequest pessoaRequest){
        return addPessoaService.insertPessoa(pessoaRequest);
    }

    @GetMapping("/")
    public Flux<PessoaResponse> listAll(){
        return listAllPessoaService.execute();
    }
}
