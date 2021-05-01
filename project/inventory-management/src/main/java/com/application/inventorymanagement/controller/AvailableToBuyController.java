package com.application.inventorymanagement.controller;

import com.application.inventorymanagement.entity.AvailableToBuy;
import com.application.inventorymanagement.entity.WholesalePurchase;
import com.application.inventorymanagement.service.AvailableToBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.MessageHandler;
import java.text.ParseException;
import java.util.Date;
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
    @CrossOrigin(origins = "http://localhost:3001")
    @GetMapping("/getAll")
    public List<AvailableToBuy> getAvailableToBuy(){
        return availableToBuyService.getAvailableToBuy();
    }

    @CrossOrigin(origins = "http://localhost:3001",allowedHeaders = "*")
    @PostMapping("/buy")
    public WholesalePurchase buyWholesale(@RequestBody WholesalePurchase wholesalePurchase) throws ParseException {
        return availableToBuyService.buyWholesale(wholesalePurchase);
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
        /*
        List<T>
        T: {name, quantity}, order date
        for{
            new Item: name, quantity, expiration
            AvailableToBuy obj  =call getavailablebyname
            if name doesn't exist in Item
                create new item (obj.getName(), ,
            else

            Billing Log: {name, quantity, price}, order date
        }
         */




//    @GetMapping
//    public AvailableToBuy getAvailableByName(String name){
//        return this.availableToBuyRepository.findByName(name);
//    }
}
