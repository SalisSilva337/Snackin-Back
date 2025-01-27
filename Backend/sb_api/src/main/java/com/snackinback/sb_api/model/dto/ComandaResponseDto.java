package com.snackinback.sb_api.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.snackinback.sb_api.model.enums.ComandaStatusEnum;
import com.snackinback.sb_api.model.enums.MetodoDePagamentoEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComandaResponseDto {
    private Integer comandaId;
    private List<ItemResponseDto> items;
    private String codigoDoPedido;
    private Double subtotal;
    private ComandaStatusEnum status;
    private LocalDateTime pedidoCriadoEm;
    private MetodoDePagamentoEnum metodoDePagamento;
}   
