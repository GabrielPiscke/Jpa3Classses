package com.example.Jpa3Classes.Repository;

import com.example.Jpa3Classes.Entity.Aluno;
import com.example.Jpa3Classes.Entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
