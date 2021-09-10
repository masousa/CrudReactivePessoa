package com.example.pessoarestdemo.tos;

import lombok.Data;

import java.util.List;

@Data
public class PessoaRequest {

    private String nome;
    private Long idade;
    private String cep;
    private String numero;
    private String complemento;

    private List<TelefoneTO> telefones;
}
