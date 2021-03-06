package com.application.inventorymanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

import static com.application.inventorymanagement.InventoryManagementApplication.moneyFormat;

/**
 * Subclass for Receipt, item_list
 */
public class RevenueItem {
    @Field
    private ObjectId item_id;
    @Field
    private String item_name;
    @Field
    private String expiration;
    @Field
    private int quantity;
    @Field
    private double price;

    public RevenueItem(){}

    public RevenueItem(ObjectId item_id, String item_name, String expiration, int quantity, double price) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.expiration = expiration;
        this.quantity = quantity;
        this.price = price;
    }

    public ObjectId getItem_id() {
        return item_id;
    }

    public void setItem_id(ObjectId item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RevenueItem{" +
                "item_id=" + item_id +
                ", item_name='" + item_name + '\'' +
                ", expiration=" + expiration +
                ", quantity=" + quantity +
                ", price=" + moneyFormat.format(price) +
                '}';
    }
}
