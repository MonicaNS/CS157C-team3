package com.application.inventorymanagement.repository;

import com.application.inventorymanagement.entity.AvailableToBuy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailableToBuyRepository extends MongoRepository<AvailableToBuy, String> {

     AvailableToBuy findByName(@Param("name") String name);
}
