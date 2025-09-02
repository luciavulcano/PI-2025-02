package com.spring.controller;

import com.spring.model.Professor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

    private List<Professor> professores = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Professor> listar() {
        return professores;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id) {
        Professor professor = professores.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (professor != null) {
            return ResponseEntity.ok(professor);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Professor salvar(@RequestBody Professor professor) {
        if (professor.getId() == null) {
            professor.setId(nextId++);
            professores.add(professor);
        } else {
            for (int i = 0; i < professores.size(); i++) {
                if (professores.get(i).getId().equals(professor.getId())) {
                    professores.set(i, professor);
                    break;
                }
            }
        }
        return professor;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizar(@PathVariable Long id, @RequestBody Professor professor) {
        professor.setId(id);
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getId().equals(id)) {
                professores.set(i, professor);
                return ResponseEntity.ok(professor);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = professores.removeIf(p -> p.getId().equals(id));
        if (removido) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}