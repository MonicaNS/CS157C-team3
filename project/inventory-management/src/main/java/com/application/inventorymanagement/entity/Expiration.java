package com.application.inventorymanagement.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

public class Expiration {
    @Field
    public Date expiry_date;
    @Field
    public int quantity;

    public Expiration(Date expiry_date, int quantity) {
        this.expiry_date = expiry_date;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "[expiry_date=" + expiry_date + ", quantity=" + quantity + "]";
    }
}