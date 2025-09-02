package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.spring")
public class MeuProjetoSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeuProjetoSpringApplication.class, args);
    }

}

