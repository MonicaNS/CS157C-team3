package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.AvailableToBuy;
import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.repository.AvailableToBuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
