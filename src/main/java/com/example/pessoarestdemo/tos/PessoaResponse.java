package com.example.pessoarestdemo.tos;

import com.example.pessoarestdemo.entities.Pessoa;
import lombok.Data;

@Data
public class PessoaResponse  extends PessoaRequest {

    private Long id;
    private AddressTO address;

    public static PessoaResponse from(Pessoa pessoa){
        PessoaResponse pessoaResponse= new PessoaResponse();
        pessoaResponse.setCep(pessoa.getCep());
        pessoaResponse.setComplemento(pessoa.getComplemento());
        pessoaResponse.setIdade(pessoa.getIdade());
        pessoaResponse.setNumero(pessoa.getNumero());
        pessoaResponse.setNome(pessoa.getNome());
        pessoaResponse.setId(pessoa.getId());
        return pessoaResponse;
    }
}
