package com.example.CadastroProduto.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProdutoDto {
    private Long id;
    private String nome;
    private int saldo;
    private int saldominimo;
    private float valor;
}
