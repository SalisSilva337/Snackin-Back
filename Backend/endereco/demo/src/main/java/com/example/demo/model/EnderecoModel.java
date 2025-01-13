package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    Long id;

    String rua;
    String cep;
    public EnderecoModel(String rua, String cep, String numero_casa) {
        this.rua = rua;
        this.cep = cep;
        this.numero_casa = numero_casa;
    }
    String numero_casa;
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero_casa() {
        return numero_casa;
    }
    public void setNumero_casa(String numero_casa) {
        this.numero_casa = numero_casa;
    }
  
}
