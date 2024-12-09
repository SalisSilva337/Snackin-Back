package com.produto.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.produto.demo.Model.Produto;
import com.produto.demo.Service.ProdutoService;

@RestController
public class ProdutoController {
    
    private ProdutoService produtoService;
    
    public void ProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/addproduto")
    public void adicionarProduto(@RequestBody Produto request){
        produtoService.addProduto(request);
    }

    @GetMapping("/all")
    public List<Produto> listarProdutos(){
        List<Produto> produtos = produtoService.listarTodosOsProdutos();
                return produtos;
    }

    @PutMapping("/{id}")
    public void atualizarProduto(@RequestBody Produto update, @PathVariable Long id){
        produtoService.updateProduto(id,update);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deleteProdutoById(id);
    }

}
