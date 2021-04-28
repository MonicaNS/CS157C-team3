package com.application.inventorymanagement.repository;

import com.application.inventorymanagement.entity.BillingLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingLogRepository extends MongoRepository<BillingLog, String> {
}
