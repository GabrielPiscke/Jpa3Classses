package com.example.Jpa3ClassesDtoJava21.Repository;

import com.example.Jpa3ClassesDtoJava21.Entity.Aluno;
import com.example.Jpa3ClassesDtoJava21.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
