package com.example.Jpa3ClassesDtoJava21.Service;

import com.example.Jpa3ClassesDtoJava21.Dto.ProfessorDto;
import com.example.Jpa3ClassesDtoJava21.Entity.Professor;
import com.example.Jpa3ClassesDtoJava21.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor fromDTO(ProfessorDto professorDto){
        Professor professor = new Professor();
        professor.setNome(professorDto.getNome());
        professor.setCpf(professorDto.getCpf());
        return professor;
    }
    public Professor save (ProfessorDto professorDto){
        Professor professor = this.fromDTO(professorDto);
        Professor professorBd = professorRepository.save(professor);
        return professorBd;
    }
}
