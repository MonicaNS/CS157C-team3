package com.application.inventorymanagement.service;

import com.application.inventorymanagement.controller.ItemController;
import com.application.inventorymanagement.entity.*;
import com.application.inventorymanagement.repository.AvailableToBuyRepository;
import com.application.inventorymanagement.repository.BillingLogRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AvailableToBuyService {

    private final AvailableToBuyRepository availableToBuyRepository;

    @Autowired
    public AvailableToBuyService(AvailableToBuyRepository availableToBuyRepository) {
        this.availableToBuyRepository = availableToBuyRepository;
    }

    public List<AvailableToBuy> getAvailableToBuy(){
        return availableToBuyRepository.findAll();
    }

//    public WholesalePurchase buyWholesale(WholesalePurchase wholesalePurchase){
//        List<WholesaleItem> wholesaleItems = wholesalePurchase.getWholesaleItems();
//        ArrayList<BillingItem> billingItemArraylist = new ArrayList<BillingItem>();
//        for(WholesaleItem wholesaleItem : wholesaleItems){
//            BillingItem tempBI = new BillingItem(
//                    wholesaleItem.getName(),
//                    wholesaleItem.getQuantity(),
//                    wholesaleItem.getPrice());
//            billingItemArraylist.add(tempBI);
//
//        }
//        double totalPrice = 0;
//        int totalQuantity = 0;
//        for(BillingItem billingItem : billingItemArraylist){
//            totalPrice += billingItem.getPrice();
//            totalQuantity += billingItem.getQuantity();
//        }
//        new BillingLog(wholesalePurchase.getOrderDate(), totalQuantity, totalPrice, billingItemArraylist;
//
//    }

}
