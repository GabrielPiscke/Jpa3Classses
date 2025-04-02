package com.example.CadastroProduto.Repository;

import com.example.CadastroProduto.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
