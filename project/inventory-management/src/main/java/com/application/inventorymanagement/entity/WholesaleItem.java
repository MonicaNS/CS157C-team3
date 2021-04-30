package com.application.inventorymanagement.entity;

import java.util.Date;

public class WholesaleItem {
    private String name;
    private int quantity;
    private double price;
    private String expiration;

    public WholesaleItem(String name, int quantity, double price, String expiration) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "WholesaleItem{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", expiration=" + expiration +
                '}';
    }
}
