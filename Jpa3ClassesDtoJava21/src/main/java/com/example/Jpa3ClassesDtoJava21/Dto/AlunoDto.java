package com.example.Jpa3ClassesDtoJava21.Dto;

import com.example.Jpa3ClassesDtoJava21.Entity.Curso;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class AlunoDto {
    private long idAluno;
    private String nome;
    private String cpf;
    @JsonIgnoreProperties("alunos")
    private Curso curso;

    public AlunoDto(){

    }

    public AlunoDto(long idAluno, String nome, String cpf, Curso curso) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
    }

    public long getId() {
        return idAluno;
    }

    public void setId(long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
