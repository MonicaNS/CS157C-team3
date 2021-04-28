package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.repository.ItemRepository;
import com.application.inventorymanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private static ItemService itemService;

    @GetMapping("/getAllItems")
    public List<Item> getItems(){
        return itemService.getItems();
    }

    @GetMapping("/exists")
    public boolean exists(String name){
        return itemService.exists(name);
    }


//
//    @PostMapping
//    public void createItem(@RequestBody){
//        if()
//    }
}

