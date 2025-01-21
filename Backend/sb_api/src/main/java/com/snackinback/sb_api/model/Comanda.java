package com.snackinback.sb_api.model;

import java.time.LocalDateTime;
import java.util.List;

import com.snackinback.sb_api.model.enums.ComandaStatusEnum;
import com.snackinback.sb_api.model.enums.MetodoDePagamentoEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comandas")
@Data
@NoArgsConstructor
public class Comanda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "comanda", cascade=CascadeType.ALL)
    private List<Item> item;
    
    @Column(unique = true)
    private String numeroDoPedido;
    private ComandaStatusEnum status;
    private Double subtotal;
    private LocalDateTime pedidoCriadoEm;
    private LocalDateTime update;
    private MetodoDePagamentoEnum metodoDePagamento;

}
