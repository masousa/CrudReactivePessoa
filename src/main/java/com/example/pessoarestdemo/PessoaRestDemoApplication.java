package com.example.pessoarestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PessoaRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PessoaRestDemoApplication.class, args);
    }

}
