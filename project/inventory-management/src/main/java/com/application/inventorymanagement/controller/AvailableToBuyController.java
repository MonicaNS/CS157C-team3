package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.AvailableToBuy;
import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.repository.AvailableToBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class AvailableToBuyController {
    private final AvailableToBuyRepository availableToBuyRepository;

    @Autowired
    public AvailableToBuyController(AvailableToBuyRepository availableToBuyRepository) {
        this.availableToBuyRepository = availableToBuyRepository;
    }

    @GetMapping("/getAllAvailableToBuy")
    public List<AvailableToBuy> getAvailableToBuy(){
        return availableToBuyRepository.findAll();
    }

    @GetMapping("/getAllAvailableToBuyPage")
    public Page<AvailableToBuy> getAvailableToBuyPage() {
        Pageable p = PageRequest.of(0, Integer.MAX_VALUE);
        return availableToBuyRepository.findAll(p);
    }
    /**
    Functions:
     request to buy
        asks for name, quantity, price
     */

    /*
    Make method that would get the information from the Available To Buy (wholesale) page.
    The information would be sent to both ItemController and BillingLogController to create Items
    and BillingLogs, and saves to the database.
     */





    @GetMapping
    public AvailableToBuy getAvailableByName(String name){
        return this.availableToBuyRepository.findByName(name);
    }
}
