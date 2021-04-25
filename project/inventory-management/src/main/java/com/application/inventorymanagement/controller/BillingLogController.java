package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.BillingLog;
import com.application.inventorymanagement.repository.BillingLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillingLogController {
    private final BillingLogRepository billingLogRepository;

    @Autowired
    public BillingLogController(BillingLogRepository billingLogRepository) {
        this.billingLogRepository = billingLogRepository;
    }

    @GetMapping("/getAllBillingLogs")
    public List<BillingLog> getBillingLogs(){
        return billingLogRepository.findAll();
    }

    @GetMapping("/getAllBillingLogsPage")
    public Page<BillingLog> getBillingLogsPage() {
        Pageable p = PageRequest.of(0, Integer.MAX_VALUE);
        return billingLogRepository.findAll(p);
    }

}
