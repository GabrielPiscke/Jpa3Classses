package com.example.Jpa3ClassesDtoJava21.Service;

import com.example.Jpa3ClassesDtoJava21.Dto.AlunoDto;
import com.example.Jpa3ClassesDtoJava21.Entity.Aluno;

import com.example.Jpa3ClassesDtoJava21.Repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno fromDTO(AlunoDto alunoDTO){
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setCpf(alunoDTO.getCpf());
        aluno.setCurso(alunoDTO.getCurso());

        return aluno;
    }

    public AlunoDto toDTO(Aluno aluno){
        AlunoDto alunoDTO = new AlunoDto();
        alunoDTO.setId(aluno.getIdAluno());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setCpf(aluno.getCpf());
        alunoDTO.setCurso(aluno.getCurso());

        return alunoDTO;
    }

    public List<Aluno> getAll(){
        return alunoRepository.findAll();
    }

    public Optional<AlunoDto> getById(Long id){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if(optionalAluno.isPresent()){
            return Optional.of(this.toDTO(optionalAluno.get()));
        }else {
            return Optional.empty();
        }
//        return alunoRepository.findById(id).map(this::toDTO);
    }

    public AlunoDto saveDto(AlunoDto alunoDTO){
        Aluno aluno = this.fromDTO(alunoDTO);
        Aluno alunoBd = alunoRepository.save(aluno);
        return this.toDTO(alunoBd);
    }

    public Optional<AlunoDto> updateAluno(Long id, AlunoDto alunoDTO){
        Optional<Aluno> optionalAluno = alunoRepository.findById(id);
        if(optionalAluno.isPresent()){
            Aluno aluno = optionalAluno.get();
            aluno.setNome(alunoDTO.getNome());
            aluno.setCpf(alunoDTO.getCpf());
            aluno.setCurso(alunoDTO.getCurso());

            Aluno alunoUpdate = alunoRepository.save(aluno);

            return Optional.of(this.toDTO(alunoUpdate));
        }else {
            return Optional.empty();
        }
    }
    public boolean delete(Long id){
        if(alunoRepository.existsById(id)){
            alunoRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
