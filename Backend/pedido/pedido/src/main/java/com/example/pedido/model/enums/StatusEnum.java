package com.example.pedido.model.enums;


public enum StatusEnum {

    PENDENTE("Pendente."),
    EM_PREPARO("Em preparo..."),
    FINALIZADO("Finalizado.");

    private String statusString;

    StatusEnum(String status){
    this.statusString = status;
    }

    public String getStatusString(){
        return this.statusString;
    }


}
