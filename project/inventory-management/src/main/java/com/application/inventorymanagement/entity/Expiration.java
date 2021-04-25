package com.application.inventorymanagement.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Subclass for Item, Expiration array
 */
public class Expiration {
    @Field
    public Date expiry_date;
    @Field
    public int quantity;

    public Expiration(Date expiry_date, int quantity) {
        this.expiry_date = expiry_date;
        this.quantity = quantity;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Expiration{" +
                "expiry_date=" + expiry_date +
                ", quantity=" + quantity +
                '}';
    }

//    @Override
//    public String toString(){
//        return "[expiry_date=" + expiry_date + ", quantity=" + quantity + "]";
//    }
}