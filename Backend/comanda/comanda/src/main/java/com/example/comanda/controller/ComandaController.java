package com.example.comanda.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.comanda.model.Comanda;
import com.example.comanda.service.ComandaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/comandas")
@RequiredArgsConstructor
public class ComandaController {
    private final ComandaService comandaService;

    @PostMapping
    public void criarComanda(@RequestBody Comanda request){
        comandaService.addComanda(request);
    }

    @GetMapping("/{id}")
    public Comanda getById(@PathVariable Long id){
        return comandaService.getComandaById(id);
    }

    @GetMapping
    public List<Comanda> getAllComandas(){
        return comandaService.listarTodasAsComandas();
    }
}
