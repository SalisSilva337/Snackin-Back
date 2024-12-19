package com.produto.demo.model.dto;

import com.produto.demo.model.enums.CategoriaEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequestDto {
    @Id
    private Integer id;
    
    private String nome;
    private Double preco;
    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;
    private String descricao;
}
