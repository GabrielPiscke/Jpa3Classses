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
    @PutMapping("/{id}")
    public  ResponseEntity<Object> update(@PathVariable long id, @RequestBody Curso cursoUpdate){
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if(cursoOptional.isPresent()){
            Curso curso = cursoOptional.get();
            curso.setNome(cursoUpdate.getNome());
            curso.setProfessor(cursoUpdate.getProfessor());
            curso.setNumeroSala(cursoUpdate.getNumeroSala());
            cursoRepository.save(curso);
            return ResponseEntity.status(HttpStatus.OK).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        Optional<Curso> cursoOptional = cursoRepository.findById(id);
        if(cursoOptional.isPresent()){
            Curso curso = cursoOptional.get();
            cursoRepository.delete(curso);
            return ResponseEntity.status(HttpStatus.FOUND).body("Curso deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao deletar o curso!");
        }
    }
}

