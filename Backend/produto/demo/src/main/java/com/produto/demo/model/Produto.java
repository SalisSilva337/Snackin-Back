package com.produto.demo.model;


import com.produto.demo.model.enums.CategoriaEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Double preco;
    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;
    private String descricao;
    
    public Produto() {
    }

}
