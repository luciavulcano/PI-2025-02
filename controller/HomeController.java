package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/api")
    @ResponseBody
    public Map<String, Object> apiInfo() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Sistema de Gestão - API Backend");
        response.put("version", "1.0.0");
        response.put("endpoints", new String[]{
            "/api/aluno", "/api/pessoa-fisica", "/api/pessoa-juridica", 
            "/api/professor", "/api/fornecedor"
        });
        return response;
    }

    @GetMapping("/aluno/form")
    public String alunoForm() {
        return "aluno";
    }

    @GetMapping("/professor/form")
    public String professorForm() {
        return "professor";
    }

    @GetMapping("/pessoa-fisica/form")
    public String pessoaFisicaForm() {
        return "pessoa-fisica";
    }

    @GetMapping("/pessoa-juridica/form")
    public String pessoaJuridicaForm() {
        return "pessoa-juridica";
    }

    @GetMapping("/fornecedor/form")
    public String fornecedorForm() {
        return "fornecedor";
    }
}