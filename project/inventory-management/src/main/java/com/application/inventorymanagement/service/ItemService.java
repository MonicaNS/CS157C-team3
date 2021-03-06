package com.application.inventorymanagement.service;

import com.application.inventorymanagement.entity.Expiration;
import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.entity.RevenueItem;
import com.application.inventorymanagement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.application.inventorymanagement.InventoryManagementApplication.dateToStr;

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

    //will upsert if item previously exists, otherwise save
    //note that it will use the price that was defined in the olditem, instead of the new item
    public Item save(Item item) throws ParseException {
        //if item previously exists, calculate the total quantity and update expiration list from new item -> old item
        if(itemRepository.existsByName(item.getName())){        //find and get the same item by name
            Item oldItem = itemRepository.findByName(item.getName()).get(0);
            for(Expiration e : item.getExpiration()){
                oldItem.insertExpiration(e);                    //will add or subtract from the quantity of the original
            }
//            oldItem.removeExpired();                          //will remove expired items
            item = oldItem;
        }
        item.setLast_modified(dateToStr(new Date()));
        return itemRepository.save(item);
    }

    public List <Item> updatePrice(String name, Double price){
        List<Item> iList = itemRepository.findByName(name);
        for(Item i: iList){
            i.setPrice(price);
            itemRepository.save(i);
        }
        return iList;
    }

    //will completely overwrite any existing items
    public Item directSave(Item item) {
        return itemRepository.save(item);
    }


    public Iterable<Item> save(List<Item> items) throws ParseException{
        List<Item> itemList = new ArrayList<Item>();
        for(Item i : items){
            itemList.add(save(i));
        }
        return itemList;
        //itemRepository.saveAll(items)
    }

    public void removeNullItems(){
        List<Item> itemList = itemRepository.findAll();
        for(Item item: itemList){
            if(item.removeEmpty()) {
                item.setLast_modified(dateToStr(new Date()));
                itemRepository.save(item);
            }
        }
    }
}
