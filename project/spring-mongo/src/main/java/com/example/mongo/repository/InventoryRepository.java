package com.example.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.mongo.entity.Inventory;


public interface InventoryRepository extends MongoRepository<Inventory, String>{
	

}
