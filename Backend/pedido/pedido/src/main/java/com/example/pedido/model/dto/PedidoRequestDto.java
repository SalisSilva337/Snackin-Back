package com.example.pedido.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDto {
    private Long numero_do_pedido;
    private String metodo_de_pagamento;
}

