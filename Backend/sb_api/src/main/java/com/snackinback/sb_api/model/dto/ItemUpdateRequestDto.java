package com.snackinback.sb_api.model.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemUpdateRequestDto {

    @Id
    private Integer id;

    private String observacao;
    private Integer quantidade;

}
