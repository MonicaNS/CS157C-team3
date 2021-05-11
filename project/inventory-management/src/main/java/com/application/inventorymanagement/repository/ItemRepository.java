package com.application.inventorymanagement.repository;

import com.application.inventorymanagement.entity.RevenueItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.application.inventorymanagement.entity.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String>{
    List<Item> findByName(String name);
    boolean existsByName(String name);


}
