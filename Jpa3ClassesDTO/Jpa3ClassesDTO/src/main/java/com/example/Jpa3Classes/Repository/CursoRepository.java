package com.example.Jpa3Classes.Repository;

import com.example.Jpa3Classes.Entity.Curso;
import com.example.Jpa3Classes.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
