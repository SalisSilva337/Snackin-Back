package com.produto.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produto.demo.model.Produto;
import com.produto.demo.model.dto.ProdutoRequestDto;
import com.produto.demo.service.ProdutoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    
    private final ProdutoService produtoService;
    
    @PostMapping
    public void adicionarProduto(@RequestBody ProdutoRequestDto request){
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
