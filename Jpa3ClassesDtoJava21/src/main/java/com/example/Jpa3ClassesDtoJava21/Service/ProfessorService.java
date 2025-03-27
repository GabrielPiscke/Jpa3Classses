package com.example.Jpa3ClassesDtoJava21.Service;

import com.example.Jpa3ClassesDtoJava21.Dto.ProfessorDto;
import com.example.Jpa3ClassesDtoJava21.Entity.Professor;
import com.example.Jpa3ClassesDtoJava21.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ProfessorDto toDTO(Professor professor){
        ProfessorDto professorDto = new ProfessorDto();
        professorDto.setNome(professor.getNome());
        professorDto.setCpf(professor.getCpf());
        return professorDto;
    }
    public List<Professor> getAll(){
        return professorRepository.findAll();
    }

    public Optional<ProfessorDto> getById(Long id){
        // busca o professor no banco de dados com base no ID
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if(optionalProfessor.isPresent()){// verifica se encontrou algum professor
            // transforma a entidade professor para DTO
            // e também coloca dentro de um objeto Optional
            return Optional.of(this.toDTO(optionalProfessor.get()));
        }else {
            return Optional.empty(); // um objeto Optional vazio.
        }
//        return professorRepository.findById(id).map(this::toDTO);
    }

    public ProfessorDto save(ProfessorDto professorDTO){
        // converte de DTO para Entidade
        Professor professor = this.fromDTO(professorDTO);
        // salva no banco de dados a entidade
        Professor professorBd = professorRepository.save(professor);
        // da return transformando novamente para DTO
        return this.toDTO(professorBd);
    }

    public Optional<ProfessorDto> updateProfessor(Long id, ProfessorDto professorDTO){
        // busca o professor no banco de dados com base no ID enviado
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        //verifica se encontrou algum professor para ser atualizado
        if(optionalProfessor.isPresent()){
            // caso encontrar um professor, instancia uma entidade com o nome "professor", passando o professor que esta no banco de dados
            Professor professor = optionalProfessor.get();
            // atualizando os dados da entidade "professor" que veio do banco de dados
            professor.setNome(professorDTO.getNome());
            professor.setCpf(professorDTO.getCpf());

            // salva no banco dados o professor com o dados atualizados
            Professor professorUpdate = professorRepository.save(professor);

            // transforma a entidade professor que veio como retorno do banco de dados em um DTO para ser retornado
            return Optional.of(this.toDTO(professorUpdate));
        }else { // se nao encontrar retonar um Objeto Optinal vazio.
            return Optional.empty();
        }
    }
    public boolean delete(Long id){
        if(professorRepository.existsById(id)){
            professorRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

}
