package com.spring.controller;

import com.spring.model.PessoaFisica;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pessoa-fisica")
public class PessoaFisicaController {

    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<PessoaFisica> listar() {
        return pessoasFisicas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaFisica> buscarPorId(@PathVariable Long id) {
        PessoaFisica pessoa = pessoasFisicas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (pessoa != null) {
            return ResponseEntity.ok(pessoa);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public PessoaFisica salvar(@RequestBody PessoaFisica pessoaFisica) {
        if (pessoaFisica.getId() == null) {
            pessoaFisica.setId(nextId++);
            pessoasFisicas.add(pessoaFisica);
        } else {
            for (int i = 0; i < pessoasFisicas.size(); i++) {
                if (pessoasFisicas.get(i).getId().equals(pessoaFisica.getId())) {
                    pessoasFisicas.set(i, pessoaFisica);
                    break;
                }
            }
        }
        return pessoaFisica;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaFisica> atualizar(@PathVariable Long id, @RequestBody PessoaFisica pessoaFisica) {
        pessoaFisica.setId(id);
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId().equals(id)) {
                pessoasFisicas.set(i, pessoaFisica);
                return ResponseEntity.ok(pessoaFisica);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = pessoasFisicas.removeIf(p -> p.getId().equals(id));
        if (removido) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}