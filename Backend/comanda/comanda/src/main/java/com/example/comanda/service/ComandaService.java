package com.example.comanda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.comanda.model.Comanda;
import com.example.comanda.repository.ComandaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComandaService {

    private final ComandaRepository comandaRepository;

    public void addComanda(Comanda request){
        comandaRepository.save(request);
    }

    public Comanda getComandaById(Long id){
        
        if (id==null) throw new RuntimeException("ID inválido.");
        Comanda comanda = comandaRepository.findById(id)
         .orElseThrow(
                () -> new RuntimeException("Pedido não encontrado")
                );
        return comanda;
                
    }

    public List<Comanda> listarTodasAsComandas(){
        return comandaRepository.findAll();
    }

}
