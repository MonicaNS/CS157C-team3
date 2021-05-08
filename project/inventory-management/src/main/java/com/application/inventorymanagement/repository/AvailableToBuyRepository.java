package com.application.inventorymanagement.repository;

import com.application.inventorymanagement.entity.AvailableToBuy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableToBuyRepository extends MongoRepository<AvailableToBuy, String> {

     AvailableToBuy findByName( String name);
}
