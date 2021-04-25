package com.application.inventorymanagement.entity;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Subclass for Billing, order_list
 */
public class BillingItem {
    @Field
    private String name;
    @Field
    private int quantity;
    @Field
    private double price;

    public BillingItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
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

    @Override
    public String toString() {
        return "BillingItem{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
