package com.application.inventorymanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.Date;

@Document(collection = "item")
public class Item {

    @Id
    private ObjectId id;
    @Field
    private String name;
    @Field
    private double price;
    @Field
    private int total_quantity;
    @Field
    private Date last_modified;
    @Field
    private Expiration[] expiration;

    public Item() {

    }

    public Item(ObjectId id, String name, double price, int total_quantity, Date last_modified, Expiration[] expiration) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.total_quantity = total_quantity;
        this.last_modified = last_modified;
        this.expiration = expiration;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotal_Quantity() {
        return total_quantity;
    }

    public void setTotal_Quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }

    public Expiration[] getExpiration() {
        return expiration;
    }

    public void setExpiration(Expiration[] expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", total_quantity=" + total_quantity +
                ", last_modified=" + last_modified +
                ", expiration=" + Arrays.toString(expiration) +
                '}';
    }

}
