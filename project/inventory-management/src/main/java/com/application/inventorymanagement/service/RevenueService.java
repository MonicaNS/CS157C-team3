package com.application.inventorymanagement.service;

import com.application.inventorymanagement.InventoryManagementApplication;
import com.application.inventorymanagement.entity.*;
import com.application.inventorymanagement.repository.RevenueRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.*;

import static com.application.inventorymanagement.InventoryManagementApplication.*;

@Service
public class RevenueService {
    private final RevenueRepository revenueRepository;

    @Autowired
    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public List<Revenue> getRevenue() {
        return revenueRepository.findAll();
    }

    public Revenue save(Revenue revenue) {
        return revenueRepository.save(revenue);
    }

    /**
     * make sure the objects in the revenue list exist in the Item collection
     * if it exists with the allowed amount of items,
     * then make decrease the amount of items purchased in revenue in the Item collection
     * @param revenue
     * @return
     * @throws ParseException
     */
    public Revenue saveReceipt(Revenue revenue) throws ParseException {

        List<RevenueItem> riList = revenue.getItem_list();

        for(RevenueItem ri : riList){
            //check if item exists
            if(!itemService.exists(ri.getItem_name())) throw new IllegalArgumentException("Item " + ri.getItem_name() + " does not exist in the Item collection");
            Item temp = itemService.getItemByName(ri.getItem_name()).get(0);

            //check if expiration exists
            if(!temp.expirationExists(ri.getExpiration())) throw new IllegalArgumentException("Item " + ri.getItem_name() + " expiration " + ri.getExpiration() + " does not exist");
            Expiration exp = temp.getExpiration(ri.getExpiration());

            //check if RevenueItem quantity is below or equal to Item's expiration quantity
            if(exp.getQuantity() < ri.getQuantity()) throw new IllegalArgumentException("Item " + ri.getItem_name() + " expiration " + ri.getExpiration() + " at " + ri.getQuantity() + " does not exist. Limited to " + exp.getQuantity());

            //original quantity - revenue item quantity
            exp.setQuantity( -ri.getQuantity() );     // sets a negative quantity, will be subtracted from the Item when saved through Item.insertExpiration

            //save to itemService
            List<Expiration> expList = new ArrayList<>();
            expList.add(exp);
            temp.setExpiration(expList);                    //previous expirations not changed will not be erased, because of how insertExpiration works
            itemService.save(temp);

            //update price to one specified in item
            ri.setPrice(temp.getPrice());

            //end loop
        }
        revenue.setItem_list(riList);       //makes sure to save the list in case of price edits
        revenue.calculateTotalCost();
        revenue.calculateQuantity();
        revenue.setDate(dateToStr(new Date()));
        return revenueRepository.save(revenue);
    }

    /**
     * This is a costly process, as it goes through all items in the collection
     * Automatically creates a Revenue object with the EXPIRED doc_type
     * Will remove expired Items from the Item collection and log it into the Revenue object
     * @return Revenue object resulted from removing expired items and insert into repository
     */
    public Revenue saveExpired() throws ParseException {
        List<Item> items = itemService.getItems();
        List<RevenueItem> expiredList = new ArrayList<RevenueItem>();
        for(Item item: items){
            //get the expiration list from each item
            List<Expiration> tempExp = item.getExpiration();

            //parse the expiry_date string into date
            for(Expiration e : tempExp) {
                //if the date is before today's date, then count the quantity
                if(strToDate(e.getExpiry_date()).before(new Date())){
                    //get price from available to buy
                    AvailableToBuy tempATB = availableToBuyService.getAvailableToBuyByName(item.getName());

                    //log the expired item into expiredlist
                    if(tempATB != null){
                        RevenueItem tempRI = new RevenueItem(new ObjectId(), item.getName(), e.getExpiry_date(), e.getQuantity(), tempATB.getPrice());
                        expiredList.add(tempRI);
                    }
                }
            }
            int totalRemoved = item.removeExpired();       //removes all expired after going through expired items
            if(totalRemoved > 0) itemService.directSave(item);      //if items were removed, it will be overwritten

        }
        Revenue revenue = new Revenue(new ObjectId(), dateToStr(new Date()), 0, 0, RevenueType.EXPIRED, expiredList);
        revenue.calculateQuantity();
        revenue.calculateTotalCost();
        return revenueRepository.save(revenue);
    }

        public void getStatistics()  {
            Map<String, double[]> totalAmountSold = new HashMap<>();
            Map<String, double[]> netItemizedRevenue = new HashMap<>();

            List<Revenue> receipts = this.getRevenue();

            // Itemized profit/Loss
            for(int i=0;i<receipts.size();i++){
                List<RevenueItem> itemList = receipts.get(i).getItem_list();
                for(int j=0;j<itemList.size();j++){
                    double[] data = new double[2];
                    String itemName = itemList.get(j).getItem_name();
                    double itemPrice = itemList.get(j).getPrice();
                    double itemQuantity = itemList.get(j).getQuantity();
                    data[0] = itemPrice;
                    data[1] = itemQuantity;
                    if(totalAmountSold.containsKey(itemName)){
                        double[] existingData = totalAmountSold.get(itemName);
                        existingData[0] += data[0];
                        existingData[1] += data[1];
                        totalAmountSold.put(itemName,existingData);
                    }else{
                        totalAmountSold.put(itemName,data);
                    }
                }
            }

            for (String key : totalAmountSold.keySet()) {
                AvailableToBuy listedData =  availableToBuyService.getAvailableToBuyByName(key);
                double priceBoughtAt = listedData.getPrice();
                double[] soldData = totalAmountSold.get(key);
                double soldPrice = soldData[0];
                double soldQuantity = soldData[1];
                double amountSpent = soldQuantity*priceBoughtAt;
                double net = soldPrice - amountSpent;
                double[] stats = new double[2];
                stats[0] = soldPrice;
                stats[1] = amountSpent;
                netItemizedRevenue.put(key,stats);
            }

        }

    }
