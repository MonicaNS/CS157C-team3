package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.entity.Receipt;
import com.application.inventorymanagement.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceiptController {
    private final ReceiptRepository receiptRepository;

    @Autowired
    public ReceiptController(ReceiptRepository receiptRepository) {
        this.receiptRepository = receiptRepository;
    }

    @GetMapping("/getAllReceipts")
    public List<Receipt> getReceipts(){return receiptRepository.findAll();}

    @GetMapping("/getAllReceiptsPage")
    public Page<Receipt> getReceiptsPage() {
        Pageable p = PageRequest.of(0, Integer.MAX_VALUE);
        return receiptRepository.findAll(p);
    }
}
