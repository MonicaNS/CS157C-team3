package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @GetMapping("/getAllItems")
    public List<Item> getItems(){
        return itemRepository.findAll();
    }

    @GetMapping("/getAllItemsPage")
    public Page<Item> getItemsPage() {
        Pageable p = PageRequest.of(0, Integer.MAX_VALUE);
        return itemRepository.findAll(p);
    }
}
