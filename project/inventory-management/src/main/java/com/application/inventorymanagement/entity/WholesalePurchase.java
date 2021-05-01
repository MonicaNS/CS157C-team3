package com.application.inventorymanagement.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public class WholesalePurchase {
    private ObjectId id;
    private Date order_date;
    private List<WholesaleItem> wholesale_items;

    public WholesalePurchase(){}

    public WholesalePurchase(Date order_date, List<WholesaleItem> wholesale_items) {
        this.id = new ObjectId();
        this.order_date = order_date;
        this.wholesale_items = wholesale_items;
    }

//    public WholesalePurchase(String order_date, List<WholesaleItem> wholesale_items) {
//        this.id = new ObjectId();
//        this.order_date = order_date;
//        this.wholesale_items = wholesale_items;
//    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public List<WholesaleItem> getWholesale_items() {
        return wholesale_items;
    }

    public void setWholesale_items(List<WholesaleItem> wholesale_items) {
        this.wholesale_items = wholesale_items;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WholesalePurchase{" +
                "orderDate=" + order_date +
                ", wholesaleItems=" + wholesale_items +
                '}';
    }
}
