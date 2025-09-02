package com.spring.controller;

import com.spring.model.PessoaJuridica;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pessoa-juridica")
public class PessoaJuridicaController {

    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<PessoaJuridica> listar() {
        return pessoasJuridicas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaJuridica> buscarPorId(@PathVariable Long id) {
        PessoaJuridica pessoa = pessoasJuridicas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public PessoaJuridica salvar(@RequestBody PessoaJuridica pessoaJuridica) {
        if (pessoaJuridica.getId() == null) {
            pessoaJuridica.setId(nextId++);
            pessoasJuridicas.add(pessoaJuridica);
        } else {
            for (int i = 0; i < pessoasJuridicas.size(); i++) {
                if (pessoasJuridicas.get(i).getId().equals(pessoaJuridica.getId())) {
                    pessoasJuridicas.set(i, pessoaJuridica);
                    break;
                }
            }
        }
        return pessoaJuridica;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaJuridica> atualizar(@PathVariable Long id, @RequestBody PessoaJuridica pessoaJuridica) {
        pessoaJuridica.setId(id);
        for (int i = 0; i < pessoasJuridicas.size(); i++) {
            if (pessoasJuridicas.get(i).getId().equals(id)) {
                pessoasJuridicas.set(i, pessoaJuridica);
                return ResponseEntity.ok(pessoaJuridica);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = pessoasJuridicas.removeIf(p -> p.getId().equals(id));
        if (removido) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}