package com.example.Jpa3Classes.Controller;

import com.example.Jpa3Classes.Entity.Curso;
import com.example.Jpa3Classes.Entity.Professor;
import com.example.Jpa3Classes.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Curso")
public class ControllerCurso {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public ResponseEntity<Curso> created(@RequestBody Curso curso){
        Curso cursoBd = cursoRepository.save(curso);
            return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }

    @GetMapping
    public ResponseEntity<Curso> getAll(@RequestBody Curso curso){
        List<Curso> cursoOptional = cursoRepository.findAll();
        if (cursoOptional.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.FOUND).body(curso);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
