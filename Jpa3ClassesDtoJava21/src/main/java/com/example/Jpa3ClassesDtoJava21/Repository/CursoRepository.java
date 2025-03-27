package com.example.Jpa3ClassesDtoJava21.Repository;

import com.example.Jpa3ClassesDtoJava21.Entity.Curso;
import com.example.Jpa3ClassesDtoJava21.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
