package com.application.inventorymanagement.repository;

import com.application.inventorymanagement.entity.NetIncome;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetIncomeRepository extends MongoRepository<NetIncome, String> {
}
