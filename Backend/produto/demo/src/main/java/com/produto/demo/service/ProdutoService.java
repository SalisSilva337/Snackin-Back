package com.produto.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.produto.demo.model.Produto;
import com.produto.demo.model.dto.ProdutoRequestDto;
import com.produto.demo.model.enums.CategoriaEnum;
import com.produto.demo.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProdutoService {
    
    private final ProdutoRepository produtoRepository;

    public void addProduto(ProdutoRequestDto request){
        Produto novoProduto = new Produto();
        novoProduto.setNome(request.getNome());
        novoProduto.setPreco(request.getPreco());
        novoProduto.setCategoria(CategoriaEnum.ACOMPANHAMENTO);
        novoProduto.setDescricao(request.getDescricao());
        produtoRepository.save(novoProduto);
    }

    public List<Produto> listarTodosOsProdutos(){
        return produtoRepository.findAll();
    }

    public void updateProduto(Long id, Produto update){
        Produto produto = produtoRepository.findById(id)
            .orElseThrow(

                () -> new RuntimeException("Produto não encontrado.")

                );

        produto.setNome(update.getNome());
        produto.setPreco(update.getPreco());
        produto.setDescricao(update.getDescricao());
        produto.setCategoria(update.getCategoria());
        
        produtoRepository.save(produto);
   
    }

    public void atualizarProduto(Long id, Produto update) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarProduto'");
    }

    public void deleteProdutoById(Long id){
        if(id == null) throw new RuntimeException("id não válido");
        produtoRepository.deleteById(id);
    }

}
