package com.snackinback.sb_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.snackinback.sb_api.model.Cliente;
import com.snackinback.sb_api.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public void addCliente(Cliente request){
        
        clienteRepository.save(request);
    }

     public Cliente getClienteById(Long id){
        
        if (id==null) throw new RuntimeException("ID inválido.");
        Cliente cliente = clienteRepository.findById(id)
         .orElseThrow(
                () -> new RuntimeException("Cliente não encontrado")
                );
        return cliente;
                
    }

    public List<Cliente> listarTodosOsClientes(){
        return clienteRepository.findAll();
    }

    public void updateCliente(Long id, Cliente update){
        if(id == null)throw new RuntimeException("ID inválido");
        
            Cliente cliente = clienteRepository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException("Cliente não encontrado.")
                        );
            cliente.setNome(update.getNome());
            cliente.setTelefone(update.getTelefone());
            
            clienteRepository.save(cliente);

    }

    public void deleteCliente(Long id){
        if(id == null)throw new RuntimeException("ID inválido.");
        clienteRepository.deleteById(id);
    }
}