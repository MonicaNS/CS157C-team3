package com.application.inventorymanagement.service;

import com.application.inventorymanagement.entity.BillingLog;
import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.repository.BillingLogRepository;
import com.application.inventorymanagement.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingLogService {
    @Autowired
    private final BillingLogRepository billingLogRepository;


    public BillingLogService(BillingLogRepository billingLogRepository) {
        this.billingLogRepository = billingLogRepository;
    }

    public List<BillingLog> getBillingLogs(){
        return billingLogRepository.findAll();
    }

    public BillingLog save(BillingLog billingLog){
        return billingLogRepository.save(billingLog);
    }

    public Iterable<BillingLog> save(List<BillingLog> billingLogs){
        return billingLogRepository.saveAll(billingLogs);
    }

}
