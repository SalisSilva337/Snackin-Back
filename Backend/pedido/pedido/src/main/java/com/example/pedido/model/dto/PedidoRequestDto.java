package com.example.pedido.model.dto;

import com.example.pedido.model.enums.PagamentoEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDto {
    private Long numero_do_pedido;
    private PagamentoEnum metodo_de_pagamento;
}

