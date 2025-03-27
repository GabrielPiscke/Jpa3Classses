package com.example.Jpa3ClassesDtoJava21.Controller;


import com.example.Jpa3ClassesDtoJava21.Entity.Aluno;
import com.example.Jpa3ClassesDtoJava21.Entity.Aluno;
import com.example.Jpa3ClassesDtoJava21.Repository.AlunoRepository;
import com.example.Jpa3ClassesDtoJava21.Repository.AlunoRepository;
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

}

