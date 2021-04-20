package com.application.inventorymanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.application.inventorymanagement.entity.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String>{


}
