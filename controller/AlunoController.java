package com.spring.controller;

import com.spring.model.Aluno;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController {

    private List<Aluno> alunos = new ArrayList<>();
    private Long nextId = 1L;

    @GetMapping
    public List<Aluno> listar() {
        return alunos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Aluno aluno = alunos.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId(nextId++);
            alunos.add(aluno);
        } else {
            for (int i = 0; i < alunos.size(); i++) {
                if (alunos.get(i).getId().equals(aluno.getId())) {
                    alunos.set(i, aluno);
                    break;
                }
            }
        }
        return aluno;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        aluno.setId(id);
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getId().equals(id)) {
                alunos.set(i, aluno);
                return ResponseEntity.ok(aluno);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removido = alunos.removeIf(a -> a.getId().equals(id));
        if (removido) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
