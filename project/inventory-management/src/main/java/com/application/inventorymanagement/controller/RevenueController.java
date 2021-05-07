package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.Revenue;
import com.application.inventorymanagement.service.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/revenue")
public class RevenueController {
    private RevenueService revenueService;

    @Autowired
    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping("/getAll")
    public List<Revenue> getRevenue() {
        return revenueService.getRevenue();
    }

}
