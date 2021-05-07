package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.BillingLog;
import com.application.inventorymanagement.repository.BillingLogRepository;
import com.application.inventorymanagement.service.BillingLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billinglog")
public class BillingLogController {
    private BillingLogService billingLogService;

    @Autowired
    public BillingLogController(BillingLogService billingLogService) {
        this.billingLogService = billingLogService;
    }

    @GetMapping("/getAll")
    public List<BillingLog> getBillingLogs(){
        return billingLogService.getBillingLogs();
    }

    //2. we receive the billing log order from available to buy
    //will write to billing log collection
    @PostMapping("/save")
    public BillingLog saveBillingLog(@RequestBody BillingLog billingLog){
        return billingLogService.save(billingLog);
    }
}
