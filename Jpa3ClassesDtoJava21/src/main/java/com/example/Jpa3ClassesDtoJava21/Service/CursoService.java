package com.example.Jpa3ClassesDtoJava21.Service;

import com.example.Jpa3ClassesDtoJava21.Dto.CursoDtoRequest;
import com.example.Jpa3ClassesDtoJava21.Dto.CursoDtoResponse;
import com.example.Jpa3ClassesDtoJava21.Entity.Curso;
import com.example.Jpa3ClassesDtoJava21.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    // teremos dois objetos DTO para ser trabalhado devido
    // a entrada das informações de alunos não serem feitas pelo Curso, ou seja o CursoDtoRequest nao tem o aluno
    // no caso da saida de dados, ao retornar um curso será retornado o seus alunos, assim será utilizado CursoDtoResponse

    // converte de CursoDtoRequest para Curso
    public Curso fromDTO(CursoDtoRequest cursoDTORequest){
        Curso curso = new Curso();
        curso.setNome(cursoDTORequest.getNome());
        curso.setNumeroSala(cursoDTORequest.getNumeroSala());
        curso.setProfessor(cursoDTORequest.getProfessor());

        return curso;
    }

    // converte de Curso para CursoDTO response
    public CursoDtoResponse toDTO(Curso curso){
        CursoDtoResponse cursoDTOResponse = new CursoDtoResponse();
        cursoDTOResponse.setId(curso.getIdCurso());
        cursoDTOResponse.setNome(curso.getNome());
        cursoDTOResponse.setNumeroSala(curso.getNumeroSala());
        cursoDTOResponse.setProfessor(curso.getProfessor());
        cursoDTOResponse.setAlunos(curso.getAlunos());

        return cursoDTOResponse;
    }

    public List<Curso> getAll(){
        return cursoRepository.findAll();
    }

    public Optional<CursoDtoResponse> getById(Long id){
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if(optionalCurso.isPresent()){// verifica se encontrou algum professor
            return Optional.of(this.toDTO(optionalCurso.get()));
        }else {
            return Optional.empty(); // um objeto Optional vazio.
        }
//        return professorRepository.findById(id).map(this::toDTO);
    }

    public CursoDtoResponse saveDto(CursoDtoRequest cursoDTORequest){
        Curso curso = this.fromDTO(cursoDTORequest);
        Curso cursoBd = cursoRepository.save(curso);
        return this.toDTO(cursoBd);
    }

    public Optional<CursoDtoResponse> updateCurso(Long id, CursoDtoRequest cursoDTORequest){
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if(optionalCurso.isPresent()){
            Curso curso = optionalCurso.get();
            curso.setNome(cursoDTORequest.getNome());
            curso.setNumeroSala(cursoDTORequest.getNumeroSala());
            curso.setProfessor(cursoDTORequest.getProfessor());

            Curso cursoUpdate = cursoRepository.save(curso);

            return Optional.of(this.toDTO(cursoUpdate));
        }else {
            return Optional.empty();
        }
    }

    public boolean delete(Long id){
        if(cursoRepository.existsById(id)){
            cursoRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
