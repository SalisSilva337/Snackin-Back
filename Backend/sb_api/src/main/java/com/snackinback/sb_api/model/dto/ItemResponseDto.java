package com.snackinback.sb_api.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDto {
    private String produtoNome;
    private Integer quantidade;
    private Double totalItem;
    private Double subtotal;
}
