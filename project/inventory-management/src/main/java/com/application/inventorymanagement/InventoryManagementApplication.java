package com.application.inventorymanagement;

import com.application.inventorymanagement.controller.*;
import com.application.inventorymanagement.entity.*;
import com.application.inventorymanagement.repository.*;
import com.application.inventorymanagement.service.*;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
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

//    private ItemRepository itemRepository;
    private BillingLogRepository billingLogRepository;
//    private ReceiptRepository receiptRepository;
//    private AvailableToBuyRepository availableToBuyRepository;
//    private NetIncomeRepository netIncomeRepository;

//    @Autowired
//    public InventoryManagementApplication(ItemRepository itemRepository, BillingLogRepository billingLogRepository, ReceiptRepository receiptRepository, AvailableToBuyRepository availableToBuyRepository, NetIncomeRepository netIncomeRepository){
//        this.itemRepository = itemRepository;
//        this.billingLogRepository = billingLogRepository;
//        this.receiptRepository = receiptRepository;
//        this.availableToBuyRepository = availableToBuyRepository;
//        this.netIncomeRepository = netIncomeRepository;
//    }


    /*
    cannot access this without initializing InvMgmtApp, which is not a good idea
    cannot make the variables static
     */

    public static ItemService itemService;
    public static BillingLogService billingLogService;
    public static AvailableToBuyService availableToBuyService;
    public static RevenueService revenueService;
    @Autowired
    public InventoryManagementApplication(ItemRepository itemRepository,
                                          BillingLogRepository billingLogRepository,
                                          AvailableToBuyRepository availableToBuyRepository,
                                          RevenueRepository revenueRepository) {
        this.itemService = new ItemService(itemRepository);
        this.billingLogService = new BillingLogService(billingLogRepository);
        this.availableToBuyService = new AvailableToBuyService(availableToBuyRepository);
        this.revenueService = new RevenueService(revenueRepository);
    }

/*
start of application dump, expired and note it in revenue
 */
    public static void main(String[] args) {
        SpringApplication.run(InventoryManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
//        Item tempI = itemService.getItemByName("banana").get(0);
//        RevenueItem ri = new RevenueItem(tempI.getId(), tempI.getName(), tempI.getExpiration().get(0).getExpiry_date(), 5, tempI.getPrice());
//        ArrayList<RevenueItem> riList = new ArrayList<RevenueItem>();
//        riList.add(ri);
//        Revenue r = new Revenue(new ObjectId(), new Date(), 5, tempI.getPrice() * 5, RevenueType.RECEIPT, riList);
//        System.out.println(revenueService.getRevenue());
//        Expiration tempE = new Expiration(new Date(121, 5, 1), 3);
//        List<Expiration> e = new ArrayList<Expiration>();
//        e.add(tempE);
//        Item temp = new Item(new ObjectId(), "strawberry juice", 4.25, 3, new Date(),e);
//        itemService.save(temp);

//        System.out.println(itemService.getItems());
//        System.out.println(billingLogService.getBillingLogs());
//        System.out.println(availableToBuyService.getAvailableToBuy());

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

//        List <Item> i = itemRepository.findAll();
//
//        for(Item item: i ) {
//            System.out.println(item);
//        }
//
//        List<BillingLog> b = billingLogRepository.findAll();
//
//        for(BillingLog billingLog: b){
//            System.out.println(billingLog);
//        }
//
//        List<Receipt> r = receiptRepository.findAll();
//
//        for(Receipt receipt : r){
//            System.out.println(receipt);
//        }
//
//        List<AvailableToBuy> a = availableToBuyRepository.findAll();
//
//        for(AvailableToBuy availableToBuy : a){
//            System.out.println(availableToBuy);
//        }
//
//        List<NetIncome> n = netIncomeRepository.findAll();
//
//        for(NetIncome netIncome : n){
//            System.out.println(netIncome);
//        }
//
//        System.out.println(availableToBuyRepository.findByName("banana"));
    }

}
