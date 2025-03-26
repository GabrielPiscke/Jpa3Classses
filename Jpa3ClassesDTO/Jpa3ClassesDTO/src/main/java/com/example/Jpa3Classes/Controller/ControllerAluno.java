package com.example.Jpa3Classes.Controller;


import com.example.Jpa3Classes.Entity.Aluno;
import com.example.Jpa3Classes.Entity.Aluno;
import com.example.Jpa3Classes.Repository.AlunoRepository;
import com.example.Jpa3Classes.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Aluno")
public class ControllerAluno {
    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<Aluno> created(@RequestBody Aluno aluno) {
        Aluno alunoBd = alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll() {
        return ResponseEntity.ok(alunoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getByid(@PathVariable long id) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if (optionalAluno.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body(optionalAluno.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody Aluno alunoUpdate) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setCpf(alunoUpdate.getCpf());
            aluno.setCurso(alunoUpdate.getCurso());
            aluno.setNome(alunoUpdate.getNome());
            alunoRepository.save(aluno);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            alunoRepository.delete(aluno);
            return ResponseEntity.status(HttpStatus.FOUND).body("Aluno deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar o aluno!");
        }
    }
}

