package com.example.Jpa3ClassesDtoJava21.Controller;

import com.example.Jpa3ClassesDtoJava21.Dto.ProfessorDto;
import com.example.Jpa3ClassesDtoJava21.Entity.Professor;
import com.example.Jpa3ClassesDtoJava21.Repository.ProfessorRepository;
import com.example.Jpa3ClassesDtoJava21.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Professor")
public class ControllerProfessor {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDto> created(@RequestBody ProfessorDto professorDto){
        ProfessorDto professor = professorService.save(professorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(professor);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(professorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDto> getById(@PathVariable Long id){
        Optional<ProfessorDto> professorDTO = professorService.getById(id);
        if(professorDTO.isPresent()){
            return ResponseEntity.ok(professorDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //return professorDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDto> update(@PathVariable Long id, @RequestBody ProfessorDto professorDTO){
        Optional<ProfessorDto> professorDTOOptional = professorService.updateProfessor(id, professorDTO);
        if (professorDTOOptional.isPresent()){
            return ResponseEntity.ok(professorDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(professorService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
