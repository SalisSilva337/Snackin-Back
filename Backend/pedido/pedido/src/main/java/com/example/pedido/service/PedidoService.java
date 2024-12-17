package com.example.pedido.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pedido.model.Pedido;
import com.example.pedido.model.dto.PedidoRequestDto;
import com.example.pedido.model.enums.PagamentoEnum;
import com.example.pedido.model.enums.StatusEnum;
import com.example.pedido.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public void addPedido(PedidoRequestDto request){
        Pedido novoPedido = new Pedido();
        novoPedido.setMetodo_de_pagamento(PagamentoEnum.A_VISTA);
        novoPedido.setNumero_do_pedido(request.getNumero_do_pedido());
        novoPedido.setPedido_criado_em(LocalDateTime.now());
        novoPedido.setStatus(StatusEnum.PENDENTE);
        pedidoRepository.save(novoPedido);
    }

    public Pedido getPedidoById(Long id){

        if(id == null) throw new RuntimeException("id inválido");
        Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(
                () -> new RuntimeException("Projeto não encontrado")
                );
        return pedido;
        
    }
        
    public List<Pedido> listarTodosOsPedidos(){
        return pedidoRepository.findAll();
    }
    
}
