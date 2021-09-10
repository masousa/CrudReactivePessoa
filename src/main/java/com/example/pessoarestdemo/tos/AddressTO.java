package com.example.pessoarestdemo.tos;

import lombok.Data;

@Data
public class AddressTO {
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
