package com.application.inventorymanagement.repository;

import com.application.inventorymanagement.entity.Receipt;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReceiptRepository extends MongoRepository<Receipt, String> {
}
