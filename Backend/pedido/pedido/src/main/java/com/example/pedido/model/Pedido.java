package com.example.pedido.model;

import java.time.LocalDateTime;

import com.example.pedido.model.enums.PagamentoEnum;
import com.example.pedido.model.enums.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;

    // private Integer id_cliente;
    // private Integer id_ItemPedido;

    private Long numero_do_pedido;
    private LocalDateTime pedido_criado_em;
    private StatusEnum status;
    
    private PagamentoEnum metodo_de_pagamento;

    public Pedido() {
    }
    
    
    public String getStatusString(){
        return status.getStatusString();
    }


    

}
