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
        Professor professorBd = professorService.save(professorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorDto);
    }

}
