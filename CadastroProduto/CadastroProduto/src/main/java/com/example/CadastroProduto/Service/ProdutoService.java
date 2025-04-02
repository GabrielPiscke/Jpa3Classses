package com.example.CadastroProduto.Service;

import com.example.CadastroProduto.Dto.ProdutoDto;
import com.example.CadastroProduto.Entity.Produto;
import com.example.CadastroProduto.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto fromDTO(ProdutoDto produtoDTO){
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setQuantidade(produtoDTO.getQuantidade());
        produto.setPreco(produtoDTO.getPreco());

        return produto;
    }

    public ProdutoDto toDTO(Produto produto){
        ProdutoDto produtoDTO = new ProdutoDto();
        produtoDTO.setNome(produto.getNome());
        produtoDTO.setQuantidade(produto.getQuantidade());
        produtoDTO.setPreco(produto.getPreco());

        return produtoDTO;
    }

    public List<Produto> getAll(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoDto> getById(Long id){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(optionalProduto.isPresent()){
            return Optional.of(this.toDTO(optionalProduto.get()));
        }else {
            return Optional.empty();
        }
    }

    public ProdutoDto saveDto(ProdutoDto produtoDTO){
        Produto produto = this.fromDTO(produtoDTO);
        Produto produtoBd = produtoRepository.save(produto);
        return this.toDTO(produtoBd);
    }

    public Optional<ProdutoDto> updateProduto(Long id, ProdutoDto produtoDTO){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(optionalProduto.isPresent()){
            Produto produto = optionalProduto.get();
            produto.setNome(produtoDTO.getNome());
            produto.setId(produtoDTO.getId());
            produto.setQuantidade(produtoDTO.getQuantidade());
            produto.setPreco(produtoDTO.getPreco());

            Produto produtoUpdate = produtoRepository.save(produto);

            return Optional.of(this.toDTO(produtoUpdate));
        }else {
            return Optional.empty();
        }
    }
    public boolean delete(Long id){
        if(produtoRepository.existsById(id)){
            produtoRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
