package com.snackinback.sb_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.snackinback.sb_api.model.Endereco;
import com.snackinback.sb_api.repository.EnderecoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public void addProduto(Endereco request){
        
        enderecoRepository.save(request);
    }

     public Endereco getProdutoById(Long id){
        
        if (id==null) throw new RuntimeException("ID inválido.");
        Endereco endereco = enderecoRepository.findById(id)
         .orElseThrow(
                () -> new RuntimeException("Endereço não encontrado.")
                );
        return endereco;
                
    }

    public List<Endereco> listarTodosOsEnderecos(){
        return enderecoRepository.findAll();
    }

    public void updateProduto(Long id, Endereco update){
        if(id == null)throw new RuntimeException("ID inválido.");
        
            Endereco endereco = enderecoRepository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException("Endereço não encontrado.")
                        );
            endereco.setCep(update.getCep());
            endereco.setRua(update.getRua());
            endereco.setNumero_da_casa(update.getNumero_da_casa());
            
            enderecoRepository.save(endereco);

    }

    public void deleteItem(Long id){
        if(id == null)throw new RuntimeException("ID inválido.");
        enderecoRepository.deleteById(id);
    }
}
