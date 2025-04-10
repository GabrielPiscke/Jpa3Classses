package com.example.Jpa3Classes.Controller;

import com.example.Jpa3Classes.Entity.Curso;
import com.example.Jpa3Classes.Repository.CursoRepository;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
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


}

