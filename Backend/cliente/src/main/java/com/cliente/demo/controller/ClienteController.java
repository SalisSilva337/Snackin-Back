package com.cliente.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cliente.demo.model.Cliente;
import com.cliente.demo.service.ClienteService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public void criarCliente(@RequestBody Cliente request){
        clienteService.createCliente(request);
    }
    @GetMapping
    public List<Cliente> getAllClientes(){
        return clienteService.listarClientes();
    }
}
