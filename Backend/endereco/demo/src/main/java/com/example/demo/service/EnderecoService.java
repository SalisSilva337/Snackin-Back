package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.EnderecoModel;
import com.example.demo.repository.EnderecoRepository;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<EnderecoModel> getAllEnderecos(){
        return enderecoRepository.findAll();
    }

    public void createEndereco(EnderecoModel request){
        if(request.getRua() == null || request.getRua().isBlank()) throw new RuntimeException("O nome da rua deve ser diferente de vazio");
        if(request.getCep() == null) throw new RuntimeException("Cep inválido");
        
        enderecoRepository.save(request);
    }

    public EnderecoModel getItemById(Long id){
        if(id == null) throw new RuntimeException("id não válido");
        return enderecoRepository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException("Endereço não encontrado")
                );
    }

    public void updateItemById(Long id, EnderecoModel update){
        if(update.getRua() == null ) throw new RuntimeException("O nome da rua deve ser diferente de vazio");
        if(update.getCep() == null) throw new RuntimeException("Cep inválido");
        EnderecoModel endereco = enderecoRepository.findById(id)
            .orElseThrow(
                () -> new RuntimeException("Endereço não encontrado")
            );
        endereco.setRua(update.getRua());
        endereco.setCep(update.getCep());
        endereco.setNumero_casa(update.getNumero_casa());
        enderecoRepository.save(endereco); 
    }

    public void deleteEnderecoById(Long id){
        if(id == null) throw new RuntimeException("Id não válido");
        enderecoRepository.deleteById(id);
    }
}
