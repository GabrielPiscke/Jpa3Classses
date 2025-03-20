package com.example.Jpa3Classes.Controller;


import com.example.Jpa3Classes.Entity.Aluno;
import com.example.Jpa3Classes.Entity.Curso;
import com.example.Jpa3Classes.Repository.AlunoRepository;
import com.example.Jpa3Classes.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Aluno")
public class ControllerAluno {
    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity<Aluno> created(@RequestBody Aluno aluno){
        Aluno alunoBd = alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }
}
