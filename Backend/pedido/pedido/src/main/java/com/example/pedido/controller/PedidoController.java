package com.example.pedido.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pedido.model.Pedido;
import com.example.pedido.model.dto.PedidoRequestDto;
import com.example.pedido.service.PedidoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public void criarPedido(@RequestBody PedidoRequestDto request){
        pedidoService.addPedido(request);
    }

    @GetMapping("/{id}")
    public Pedido getById(@PathVariable Long id){
        return pedidoService.getPedidoById(id);
    }

    @GetMapping
    public List<Pedido> getAllPedidos(){
        return pedidoService.listarTodosOsPedidos();
    }
   
}
