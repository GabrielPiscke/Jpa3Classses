package com.example.Jpa3Classes.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;
    private String nome;
    private  String cpf;

    @ManyToOne
    @JoinColumn(name = "idCurso", referencedColumnName = "idCurso")
    @JsonBackReference
    private Curso curso;
}
