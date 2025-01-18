package com.snackinback.sb_api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.snackinback.sb_api.model.Comanda;
import com.snackinback.sb_api.model.Item;
import com.snackinback.sb_api.model.dto.ComandaStatusRequestDto;
import com.snackinback.sb_api.model.dto.ItemUpdateRequestDto;
import com.snackinback.sb_api.model.enums.ComandaStatusEnum;
import com.snackinback.sb_api.repository.ComandaRepository;
import com.snackinback.sb_api.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComandaService {

    private final ComandaRepository comandaRepository;
    private final ItemRepository itemRepository;

    // SERVIÇOS DA COMANDA
    public void addComanda(){
        Comanda comanda = new Comanda();
        comanda.setNumero_do_pedido(UUID.randomUUID().toString());
        comanda.setMetodo_de_pagamento("");
        comanda.setPedido_criado_em(LocalDateTime.now());
        comanda.setUpdate(LocalDateTime.now());
        comanda.setStatus(ComandaStatusEnum.PENDENTE);
        comanda.setSubtotal(0.0);

        comanda = comandaRepository.save(comanda);
    }

    public Comanda getComandaById(Long id){
        
        if (id==null) throw new RuntimeException("ID inválido.");
        Comanda comanda = comandaRepository.findById(id)
         .orElseThrow(
                () -> new RuntimeException("Comanda não encontrada.")
                );
        return comanda;
                
    }

    public List<Comanda> listarTodasAsComandas(){
        return comandaRepository.findAll();
    }

    public void updateComanda(Long id, Comanda update){
        if(id == null)throw new RuntimeException("ID inválido.");
        
            Comanda comanda = comandaRepository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException("Comanda não encontrada.")
                        );
            comanda.setStatus(update.getStatus());
            comanda.setUpdate(update.getUpdate());
            comanda.setMetodo_de_pagamento(update.getMetodo_de_pagamento());
            
            comandaRepository.save(comanda);

    }

    public void updateStatusComanda(Long id, ComandaStatusRequestDto update){
        if(id == null)throw new RuntimeException("ID inválido.");
        
            Comanda comanda = comandaRepository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException("Comanda não encontrada.")
                        );
            comanda.setStatus(ComandaStatusEnum.PENDENTE);
            comanda.setStatus(update.getStatus());
    }

    public void deleteComanda(Long id){
        if(id == null)throw new RuntimeException("ID inválido.");
        comandaRepository.deleteById(id);
    }

    // SERVIÇOS DE ITEM
    public void addItem(Item request){
        itemRepository.save(request);
    }

    public Item getItemById(Long id){
        
        if (id==null) throw new RuntimeException("ID inválido.");
        Item item = itemRepository.findById(id)
         .orElseThrow(
                () -> new RuntimeException("Item não encontrado.")
                );
        return item;
                
    }
    
    public List<Item> listarTodosOsItens(){
        return itemRepository.findAll();
    }

    public void updateItem(Long id, ItemUpdateRequestDto update){
        if(id == null)throw new RuntimeException("ID inválido");
        
            Item item = itemRepository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException("Item não encontrado.")
                        );
            item.setQuantidade(update.getQuantidade());
            item.setObservacao(update.getObservacao());
            
            itemRepository.save(item);

    }

    public void deleteItem(Long id){
        if(id == null)throw new RuntimeException("ID inválido");
        itemRepository.deleteById(id);
    }

}
