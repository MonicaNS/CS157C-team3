package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.Billing;
import com.application.inventorymanagement.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillingController {
    private final BillingRepository billingRepository;

    @Autowired
    public BillingController(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @GetMapping("/getAllBilling")
    public List<Billing> getBilling(){
        return billingRepository.findAll();
    }

    @GetMapping("/getAllBillingPage")
    public Page<Billing> getBillingPage() {
        Pageable p = PageRequest.of(0, Integer.MAX_VALUE);
        return billingRepository.findAll(p);
    }

}
