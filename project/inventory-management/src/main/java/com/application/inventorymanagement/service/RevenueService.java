package com.application.inventorymanagement.service;

import com.application.inventorymanagement.entity.Revenue;
import com.application.inventorymanagement.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevenueService {
    private final RevenueRepository revenueRepository;

    @Autowired
    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public List<Revenue> getRevenue() {
        return revenueRepository.findAll();
    }
}
