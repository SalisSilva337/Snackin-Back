package com.snackinback.sb_api.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.snackinback.sb_api.model.enums.ComandaStatusEnum;
import com.snackinback.sb_api.model.enums.MetodoDePagamentoEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    // @JsonIgnore
    private List<Item> item;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(unique = true)
    private String codigoDoPedido;
    private ComandaStatusEnum status;
    private Double valorTotal;
    private LocalDateTime pedidoCriadoEm;
    private LocalDateTime update;
    private MetodoDePagamentoEnum metodoDePagamento;

}
