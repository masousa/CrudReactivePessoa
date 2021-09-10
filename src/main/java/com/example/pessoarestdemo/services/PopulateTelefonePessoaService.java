package com.example.pessoarestdemo.services;

import com.example.pessoarestdemo.entities.Telefone;
import com.example.pessoarestdemo.repositories.TelefoneRepository;
import com.example.pessoarestdemo.tos.PessoaResponse;
import com.example.pessoarestdemo.tos.TelefoneTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class PopulateTelefonePessoaService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public void execute(PessoaResponse pessoaResponse){
        pessoaResponse.setTelefones(new ArrayList<>());
        telefoneRepository.findAllByIdPessoa(pessoaResponse.getId()).filter(Objects::nonNull).subscribe(telefone -> {
            TelefoneTO telefoneTO = new TelefoneTO();
            telefoneTO.setNumero(telefone.getNumero());
            pessoaResponse.getTelefones().add(telefoneTO);
        });
    }

}
