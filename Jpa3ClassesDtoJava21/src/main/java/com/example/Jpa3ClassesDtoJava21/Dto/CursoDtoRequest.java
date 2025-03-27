package com.example.Jpa3ClassesDtoJava21.Dto;

import com.example.Jpa3ClassesDtoJava21.Entity.Aluno;
import com.example.Jpa3ClassesDtoJava21.Entity.Professor;

import java.util.List;

public class CursoDtoRequest {

    private String nome;
    private int numeroSala;
    private Professor professor;

    public CursoDtoRequest() {
    }

    public CursoDtoRequest(String nome, int numeroSala, Professor professor) {
        this.nome = nome;
        this.numeroSala = numeroSala;
        this.professor = professor;
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
}
