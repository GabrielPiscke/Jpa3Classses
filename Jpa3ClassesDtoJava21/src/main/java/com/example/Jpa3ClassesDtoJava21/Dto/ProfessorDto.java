package com.example.Jpa3ClassesDtoJava21.Dto;

public class ProfessorDto {
    private String nome;
    private String Cpf;

    public ProfessorDto() {
    }
    public ProfessorDto(String nome, String cpf) {
        this.nome = nome;
        Cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }
}
