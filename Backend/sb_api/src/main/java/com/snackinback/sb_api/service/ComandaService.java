package com.snackinback.sb_api.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.snackinback.sb_api.model.Comanda;
import com.snackinback.sb_api.model.Item;
import com.snackinback.sb_api.model.Produto;
import com.snackinback.sb_api.model.dto.ComandaResponseDto;
import com.snackinback.sb_api.model.dto.ComandaStatusRequestDto;
import com.snackinback.sb_api.model.dto.ItemRequestDto;
import com.snackinback.sb_api.model.dto.ItemResponseDto;
import com.snackinback.sb_api.model.dto.ItemUpdateRequestDto;
import com.snackinback.sb_api.model.enums.ComandaStatusEnum;
import com.snackinback.sb_api.model.enums.MetodoDePagamentoEnum;
import com.snackinback.sb_api.repository.ComandaRepository;
import com.snackinback.sb_api.repository.ItemRepository;
import com.snackinback.sb_api.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComandaService {

    private final ComandaRepository comandaRepository;
    private final ItemRepository itemRepository;
    private final ProdutoRepository produtoRepository;

    // SERVIÇOS DA COMANDA
    @SuppressWarnings("deprecation")
    public void addComanda(){
        String nPedido = RandomStringUtils.randomAlphanumeric(4).toUpperCase();
        Comanda comanda = comandaRepository.findByCodigoDoPedido(nPedido).orElse(new Comanda());//busca pelo numero

        if(comanda.getCodigoDoPedido() == null){
            comanda.setCodigoDoPedido(nPedido);
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

    public List<ComandaResponseDto> listarTodasAsComandas(){
        List<Comanda> comandas = comandaRepository.findAll();
        List<ComandaResponseDto> response = new ArrayList<>();
        List<ItemResponseDto> responseItem = new ArrayList<>();
        ComandaResponseDto itemComanda;
        ItemResponseDto item;

        for (Comanda comanda : comandas) {
            itemComanda = new ComandaResponseDto();
            itemComanda.setComandaId(comanda.getId());
            itemComanda.setCodigoDoPedido(comanda.getCodigoDoPedido());
            itemComanda.setPedidoCriadoEm(comanda.getPedidoCriadoEm());
            itemComanda.setStatus(comanda.getStatus());
            itemComanda.setMetodoDePagamento(comanda.getMetodoDePagamento());

            double cont = 0.0;

            for (Item i : comanda.getItem()) {
                item = new ItemResponseDto();
                item.setProdutoNome(i.getProduto().getNome());
                item.setCategoria(i.getProduto().getCategoria());
                item.setQuantidade(i.getQuantidade());
                item.setTotalItem(i.getQuantidade()*i.getProduto().getPreco());
                cont += item.getTotalItem();
                responseItem.add(item);
            }
            
            itemComanda.setSubtotal(cont);
            itemComanda.setItems(responseItem);
            response.add(itemComanda);
        }
        return response;
    }

    public void updateComanda(Long id, ComandaResponseDto update){
        if(id == null)throw new RuntimeException("ID inválido.");
        
            Comanda comanda = comandaRepository.findById(id)
                    .orElseThrow(
                            () -> new RuntimeException("Comanda não encontrada.")
                        );
            comanda.setStatus(update.getStatus());
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
    public void addItem(ItemRequestDto request){
        
        Produto produto = produtoRepository.findById(request.getProdutoId()).orElseThrow(() -> new RuntimeException("erro"));
        Comanda comanda = comandaRepository.findById(request.getComandaId()).orElseThrow(() -> new RuntimeException("erro"));
        Item item = new Item();
        item.setComanda(comanda);
        item.setProduto(produto);
        item.setQuantidade(request.getQuantidade());
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


