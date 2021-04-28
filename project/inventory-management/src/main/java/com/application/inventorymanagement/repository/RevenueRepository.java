package com.application.inventorymanagement.repository;

import com.application.inventorymanagement.entity.Revenue;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RevenueRepository extends MongoRepository<Revenue, String> {
}
