package com.application.inventorymanagement.service;

import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    public List<Item> getItemByName(String name){
        return itemRepository.findByName(name);
    }

    public boolean exists(String name){
        return itemRepository.existsByName(name);
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public Iterable<Item> save(List<Item> items){
        return itemRepository.saveAll(items);
    }
}
