package com.snackinback.sb_api.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.snackinback.sb_api.model.Comanda;
import com.snackinback.sb_api.model.Item;
import com.snackinback.sb_api.model.Produto;
import com.snackinback.sb_api.model.dto.ComandaStatusRequestDto;
import com.snackinback.sb_api.model.dto.ItemUpdateRequestDto;
import com.snackinback.sb_api.model.enums.ComandaStatusEnum;
import com.snackinback.sb_api.model.enums.MetodoDePagamentoEnum;
import com.snackinback.sb_api.repository.ComandaRepository;
import com.snackinback.sb_api.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComandaService {

    private final ComandaRepository comandaRepository;
    private final ItemRepository itemRepository;

    // SERVIÇOS DA COMANDA
    @SuppressWarnings("deprecation")
    public void addComanda(){
        String nPedido = RandomStringUtils.randomAlphanumeric(4).toUpperCase();
        Comanda comanda = comandaRepository.findByNumeroDoPedido(nPedido).orElse(new Comanda());//busca pelo numero

        if(comanda.getNumeroDoPedido() == null){
            comanda.setNumeroDoPedido(nPedido);
            comanda.setMetodoDePagamento(MetodoDePagamentoEnum.PIX);
            comanda.setPedidoCriadoEm(LocalDateTime.now());
            comanda.setUpdate(LocalDateTime.now());
            comanda.setStatus(ComandaStatusEnum.PENDENTE);
            comanda.setSubtotal(0.0);
    
            comanda = comandaRepository.save(comanda);
            return;
        } 
        throw new RuntimeException("Erro ao criar o pedido!");
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
            comanda.setMetodoDePagamento(update.getMetodoDePagamento());
            
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
    public void addItem(){
        Item item = new Item();
        itemRepository.save(item);
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
            
            itemRepository.save(item);

    }

    public void deleteItem(Long id){
        if(id == null)throw new RuntimeException("ID inválido");
        itemRepository.deleteById(id);
    }

}


