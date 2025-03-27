package com.example.Jpa3ClassesDtoJava21.Dto;

import com.example.Jpa3ClassesDtoJava21.Entity.Aluno;
import com.example.Jpa3ClassesDtoJava21.Entity.Professor;

import java.util.List;

public class CursoDtoResponse {
    public Long id;
    public String nome;
    public int numeroSala;
    public Professor professor;
    public List<Aluno> alunos;

    public CursoDtoResponse() {

    }

    public CursoDtoResponse(Long id, String nome, int numeroSala, Professor professor, List<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.numeroSala = numeroSala;
        this.professor = professor;
        this.alunos = alunos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
