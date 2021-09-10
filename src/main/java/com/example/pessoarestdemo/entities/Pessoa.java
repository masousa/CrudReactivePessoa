package com.example.pessoarestdemo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("pessoa")
@Data
public class Pessoa {

    @Id
    @Column("id")
    private Long id;
    @Column("nome")
    private String nome;
    @Column("idade")
    private Long idade;
    @Column("cep")
    private String cep;
    @Column("numero")
    private String numero;
    @Column("complemento")
    private String complemento;
}
