package com.example.Jpa3ClassesDtoJava21.Controller;


import com.example.Jpa3ClassesDtoJava21.Dto.AlunoDto;
import com.example.Jpa3ClassesDtoJava21.Entity.Aluno;
import com.example.Jpa3ClassesDtoJava21.Entity.Aluno;
import com.example.Jpa3ClassesDtoJava21.Repository.AlunoRepository;
import com.example.Jpa3ClassesDtoJava21.Repository.AlunoRepository;
import com.example.Jpa3ClassesDtoJava21.Service.AlunoService;
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
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> getById(@PathVariable Long id){
        Optional<AlunoDto> alunoDTO = alunoService.getById(id);
        if(alunoDTO.isPresent()){
            return ResponseEntity.ok(alunoDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //return alunoDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AlunoDto> created(@RequestBody AlunoDto alunoDto){
        AlunoDto aluno = alunoService.saveDto(alunoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> update(@PathVariable Long id, @RequestBody AlunoDto alunoDTO){
        Optional<AlunoDto> alunoDTOOptional = alunoService.updateAluno(id, alunoDTO);
        if (alunoDTOOptional.isPresent()){
            return ResponseEntity.ok(alunoDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(alunoService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}

