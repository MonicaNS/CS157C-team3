package com.application.inventorymanagement.service;

import com.application.inventorymanagement.entity.Expiration;
import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
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

    //will upsert if item previously exists, otherwise insert
    public Item save(Item item){
        //if item previously exists, calculate the total quantity and update expiration list from new item -> old item
        if(itemRepository.existsByName(item.getName())){        //find and get the same item by name
            Item oldItem = itemRepository.findByName(item.getName()).get(0);
            for(Expiration e : item.getExpiration()){
                oldItem.insertExpiration(e);
            }
            oldItem.removeExpired();
            oldItem.calculateQuantity();
            item = oldItem;
        }

        return itemRepository.save(item);
    }

    public Iterable<Item> save(List<Item> items){
        List<Item> itemList = new ArrayList<Item>();
        for(Item i : items){
            itemList.add(save(i));
        }
        return itemList;
        //itemRepository.saveAll(items)
    }
}
