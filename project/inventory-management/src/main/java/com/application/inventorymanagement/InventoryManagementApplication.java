package com.application.inventorymanagement;

import com.application.inventorymanagement.entity.Billing;
import com.application.inventorymanagement.entity.Expiration;
import com.application.inventorymanagement.entity.Receipt;
import com.application.inventorymanagement.repository.BillingRepository;
import com.application.inventorymanagement.repository.ReceiptRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.repository.ItemRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryManagementApplication implements CommandLineRunner {

//    public static MongoClient mongoClient;
//    public static MongoClientURI mongoClientURI;
//    public static MongoDatabase database;
//    public static MongoCollection collection;
    private ItemRepository itemRepository;
    private BillingRepository billingRepository;
    private ReceiptRepository receiptRepository;

    @Autowired
    public InventoryManagementApplication(ItemRepository itemRepository, BillingRepository billingRepository, ReceiptRepository receiptRepository){
        this.itemRepository = itemRepository;
        this.billingRepository = billingRepository;
        this.receiptRepository = receiptRepository;
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

        List<Billing> b = billingRepository.findAll();

        for(Billing billing: b){
            System.out.println(billing);
        }

        List<Receipt> r = receiptRepository.findAll();

        for(Receipt receipt : r){
            System.out.println(receipt);
        }


    }
}
