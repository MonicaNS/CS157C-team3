package com.application.inventorymanagement.service;

import com.application.inventorymanagement.InventoryManagementApplication;
import com.application.inventorymanagement.entity.*;
import com.application.inventorymanagement.repository.AvailableToBuyRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public WholesalePurchase buyWholesale(WholesalePurchase wholesalePurchase) throws ParseException {
        List<WholesaleItem> wholesaleItems = wholesalePurchase.getWholesale_items();
        ArrayList<BillingItem> billingItemArraylist = new ArrayList<BillingItem>();
        ArrayList<Item> itemList = new ArrayList<Item>();
        for(WholesaleItem wholesaleItem : wholesaleItems){

            Expiration expiration = new Expiration(wholesaleItem.getExpiration(), wholesaleItem.getQuantity());
            List<Expiration> expirationList = new ArrayList<Expiration>();
            expirationList.add(expiration);
            Item tempItem = new Item(new ObjectId(), wholesaleItem.getName(), wholesaleItem.getPrice(), 0, new Date(), expirationList);
            itemList.add(tempItem);


            BillingItem tempBI = new BillingItem(
                    wholesaleItem.getName(),
                    wholesaleItem.getQuantity(),
                    wholesaleItem.getPrice());
            billingItemArraylist.add(tempBI);

        }
//        double totalPrice = 0;
//        int totalQuantity = 0;
//        for(BillingItem billingItem : billingItemArraylist){
//            totalPrice += billingItem.getPrice();
//            totalQuantity += billingItem.getQuantity();
//        }
        InventoryManagementApplication.billingLogService.save(new BillingLog(wholesalePurchase.getId(), wholesalePurchase.getOrder_date(), 0, 0, billingItemArraylist));
        InventoryManagementApplication.itemService.save(itemList);
        return wholesalePurchase;
    }

}
