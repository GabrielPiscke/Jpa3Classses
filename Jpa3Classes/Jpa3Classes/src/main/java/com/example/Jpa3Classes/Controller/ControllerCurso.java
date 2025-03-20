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

    @GetMapping
    public ResponseEntity<List<Curso>> getAll(){
        List<Curso> cursoList = cursoRepository.findAll();
        if (!cursoList.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.FOUND).body(cursoList);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/{idCurso}")
    public ResponseEntity<Optional<Curso>> getById(@PathVariable long idCurso){
        Optional<Curso> curso = cursoRepository.findById(idCurso);
        if(curso.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body(curso);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{idCurso}")
    public ResponseEntity<Optional<Curso>> update(@PathVariable long idCurso, @RequestBody Curso curso){
        Optional<Curso> cursoOptional = cursoRepository.findById(idCurso);
        if(cursoOptional.isPresent()){
            curso.setNome(curso.getNome());
            curso.setNumeroSala(curso.getNumeroSala());
            curso.setProfessor(curso.getProfessor());
            return ResponseEntity.status(HttpStatus.FOUND).body(cursoOptional);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

