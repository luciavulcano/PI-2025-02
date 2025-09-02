package com.spring.controller;

import com.spring.model.Fornecedor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    private List<Fornecedor> fornecedores = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Fornecedor> listar() {
        return fornecedores;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long id) {
        Fornecedor fornecedor = fornecedores.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (fornecedor != null) {
            return ResponseEntity.ok(fornecedor);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Fornecedor salvar(@RequestBody Fornecedor fornecedor) {
        if (fornecedor.getId() == null) {
            fornecedor.setId(nextId++);
            fornecedores.add(fornecedor);
        } else {
            for (int i = 0; i < fornecedores.size(); i++) {
                if (fornecedores.get(i).getId().equals(fornecedor.getId())) {
                    fornecedores.set(i, fornecedor);
                    break;
                }
            }
        }
        return fornecedor;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        fornecedor.setId(id);
        for (int i = 0; i < fornecedores.size(); i++) {
            if (fornecedores.get(i).getId().equals(id)) {
                fornecedores.set(i, fornecedor);
                return ResponseEntity.ok(fornecedor);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = fornecedores.removeIf(f -> f.getId().equals(id));
        if (removido) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}