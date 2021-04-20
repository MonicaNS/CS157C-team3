package com.application.inventorymanagement.entity;

import java.util.Date;

public class Expiration {
    public Date expiry_date;
    public int quantity;

    public Expiration(Date expiry_date, int quantity) {
        this.expiry_date = expiry_date;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "Expired [expiry_date=" + expiry_date + ", quantity=" + quantity + "]";
    }
}