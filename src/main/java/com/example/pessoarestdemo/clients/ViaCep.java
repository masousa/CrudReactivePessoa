package com.example.pessoarestdemo.clients;

import com.example.pessoarestdemo.tos.AddressTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCEPQuery", url = "${viacep.url}")
public interface ViaCep {

    @GetMapping("/{cep}/json")
    AddressTO getCep(@PathVariable(name = "cep")String cep);
}
