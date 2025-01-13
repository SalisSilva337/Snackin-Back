package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EnderecoModel;
import com.example.demo.service.EnderecoService;

@RestController
@RequestMapping("/endereco/v1")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService){
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<EnderecoModel> getAllEnderecoModels(){
       return enderecoService.getAllEnderecos(); 
    }

    @GetMapping("/{id}")
    public EnderecoModel getItemById(@PathVariable Long id){
        return enderecoService.getItemById(id);
    }


    @PostMapping
    public void saveEndereco(@RequestBody EnderecoModel request){
        enderecoService.createEndereco(request);
    }

    @PutMapping("/{id}")
    public void updateEndereco(@PathVariable Long id,@RequestBody EnderecoModel requestUpdate){
        enderecoService.updateItemById(id,requestUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id){
        enderecoService.deleteEnderecoById(id);
    }
}
