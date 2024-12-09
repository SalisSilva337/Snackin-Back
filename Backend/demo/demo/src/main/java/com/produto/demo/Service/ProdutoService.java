package com.produto.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.produto.demo.Model.Produto;
import com.produto.demo.Repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProdutoService {
    
    private final ProdutoRepository produtoRepository;

    public void addProduto(Produto request){
        produtoRepository.save(request);
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
