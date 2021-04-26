package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.BillingLog;
import com.application.inventorymanagement.entity.NetIncome;
import com.application.inventorymanagement.repository.NetIncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NetIncomeController {
    private final NetIncomeRepository netIncomeRepository;

    @Autowired
    public NetIncomeController(NetIncomeRepository netIncomeRepository) {
        this.netIncomeRepository = netIncomeRepository;
    }

    @GetMapping("/getAllNetIncome")
    public List<NetIncome> getNetIncome(){
        return netIncomeRepository.findAll();
    }

    @GetMapping("/getAllNetIncomePage")
    public Page<NetIncome> getNetIncomePage() {
        Pageable p = PageRequest.of(0, Integer.MAX_VALUE);
        return netIncomeRepository.findAll(p);
    }

    public void updateNetIncome(){
        /*
        looks at last modified
        if last modified date is before documents from Receipt, BillingLog
         */
    }

}
