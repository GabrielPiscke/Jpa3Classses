package com.example.Jpa3ClassesDtoJava21.Controller;

import com.example.Jpa3ClassesDtoJava21.Dto.CursoDtoRequest;
import com.example.Jpa3ClassesDtoJava21.Dto.CursoDtoResponse;
import com.example.Jpa3ClassesDtoJava21.Entity.Curso;
import com.example.Jpa3ClassesDtoJava21.Repository.CursoRepository;
import com.example.Jpa3ClassesDtoJava21.Service.CursoService;
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
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDtoResponse> getById(@PathVariable Long id){
        Optional<CursoDtoResponse> cursoDTO = cursoService.getById(id);
        if(cursoDTO.isPresent()){
            return ResponseEntity.ok(cursoDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //return cursoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CursoDtoResponse> created(@RequestBody CursoDtoRequest cursoDtoRequest){
        CursoDtoResponse curso = cursoService.saveDto(cursoDtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoDtoResponse> update(@PathVariable Long id, @RequestBody CursoDtoRequest cursoDTORequest){
        Optional<CursoDtoResponse> cursoDTOResponseOp = cursoService.updateCurso(id, cursoDTORequest);
        if (cursoDTOResponseOp.isPresent()){
            return ResponseEntity.ok(cursoDTOResponseOp.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (cursoService.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

