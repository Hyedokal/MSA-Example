package com.example.itemservice.service;

import com.example.itemservice.domain.Item;
import com.example.itemservice.dto.RequestCreateItemDto;
import com.example.itemservice.repository.ItemRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository;

    public void createItem(RequestCreateItemDto dto){
        itemRepository.save(dto.toEntity());
    }

    public Item findItem(String uuid){
        return itemRepository.findByProductId(uuid);
    }
    public List<Item> findAll(){
        return itemRepository.findAll();
    }
}
