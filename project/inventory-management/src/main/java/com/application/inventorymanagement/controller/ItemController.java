package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.repository.ItemRepository;
import com.application.inventorymanagement.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/getAll")
    public List<Item> getItems(){
        return itemService.getItems();
    }

    @GetMapping("/exists/{name}")
    public boolean exists(@PathVariable(name="name") String name){
        return itemService.exists(name);
    }

    @PostMapping("/save")
    public Item save(@RequestBody Item item) throws ParseException {
        return itemService.save(item);
    }

    @GetMapping("/getByName/{name}")
    public List<Item> getItemByName(@PathVariable(name="name") String name){
        return itemService.getItemByName(name);
    }

    @PutMapping("getPrice/{name}/{price}")
    public List<Item> updatePrice(@RequestBody List<Item> i, @PathVariable("name") String name,
                                  @PathVariable("price") Double price){
        return itemService.updatePrice(name, price);
    }

    @DeleteMapping ("/removeNullItems")
    public void removeNullItems(){
        itemService.removeNullItems();
    }
}
