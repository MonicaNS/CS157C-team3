package com.application.inventorymanagement;

import com.application.inventorymanagement.entity.*;
import com.application.inventorymanagement.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;


import java.text.DecimalFormat;
import java.util.List;


@SpringBootApplication
public class InventoryManagementApplication implements CommandLineRunner {

//    public static MongoClient mongoClient;
//    public static MongoClientURI mongoClientURI;
//    public static MongoDatabase database;
//    public static MongoCollection collection;
    /*
    Consider having a separate class for this static variable.
    This will format all prices to this money format if moneyFormat.format(#) is used.
    Doesn't work on API calls
     */
    public static DecimalFormat moneyFormat = new DecimalFormat("$0.00");

    private ItemRepository itemRepository;
    private BillingLogRepository billingLogRepository;
    private ReceiptRepository receiptRepository;
    private AvailableToBuyRepository availableToBuyRepository;

    @Autowired
    public InventoryManagementApplication(ItemRepository itemRepository, BillingLogRepository billingLogRepository, ReceiptRepository receiptRepository, AvailableToBuyRepository availableToBuyRepository){
        this.itemRepository = itemRepository;
        this.billingLogRepository = billingLogRepository;
        this.receiptRepository = receiptRepository;
        this.availableToBuyRepository = availableToBuyRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

//        Expiration e1 = new Expiration(new Date(), 3);
//        Expiration e2 = new Expiration(new Date(), 2);
//        Expiration[] eList ={e1, e2};
//
//		Item item = new Item("1", "Banana", 1.0, 4, new Date(), eList );
//		Item item2 = new Item("2", "milk", 1.0, 3, new Date(), null );
//		Item item3 = new Item("3", "moreBanana", 1.0, 3, new Date(), null  );
//
//
//
//		itemRepository.save(item);
//		itemRepository.save(item2);
//		itemRepository.save(item3);
//
//		System.out.println("Customers save ");

        List <Item> i = itemRepository.findAll();

        for(Item item: i ) {
            System.out.println(item);
        }

        List<BillingLog> b = billingLogRepository.findAll();

        for(BillingLog billingLog: b){
            System.out.println(billingLog);
        }

        List<Receipt> r = receiptRepository.findAll();

        for(Receipt receipt : r){
            System.out.println(receipt);
        }

        List<AvailableToBuy> a = availableToBuyRepository.findAll();

        for(AvailableToBuy availableToBuy : a){
            System.out.println(availableToBuy);
        }

    }
}
