package com.example.pessoarestdemo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("telefone")
@Data
public class Telefone {
    @Id
    @Column("id")
    private Long id;
    @Column("numero")
    private String numero;
    @Column("id_pessoa")
    private Long idPessoa;
}
