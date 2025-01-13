package com.cliente.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cliente.demo.model.Cliente;
import com.cliente.demo.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public void createCliente(Cliente request){
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(request.getNome());
        novoCliente.setTelefone(request.getTelefone());
        clienteRepository.save(novoCliente);
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
}
