package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.AvailableToBuy;
import com.application.inventorymanagement.entity.WholesalePurchase;
import com.application.inventorymanagement.service.AvailableToBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/wholesale")
public class AvailableToBuyController {
    private AvailableToBuyService availableToBuyService;

    @Autowired
    public AvailableToBuyController(AvailableToBuyService availableToBuyService) {
        this.availableToBuyService = availableToBuyService;
    }

    //1. Get all products
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAll")
    public List<AvailableToBuy> getAvailableToBuy(){
        return availableToBuyService.getAvailableToBuy();
    }

    @CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*")
    @PostMapping("/buy")
    public WholesalePurchase buyWholesale(@RequestBody WholesalePurchase wholesalePurchase) throws ParseException {
        return availableToBuyService.buyWholesale(wholesalePurchase);
    }

    @GetMapping("/getByName/{name}")
    public AvailableToBuy getAvailableToBuyByName(@PathVariable(name="name") String name){
        return availableToBuyService.getAvailableToBuyByName(name);
    }
}
