package com.application.inventorymanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;

import static com.application.inventorymanagement.InventoryManagementApplication.moneyFormat;
@Document(collection="available_to_buy")
public class AvailableToBuy {
    @Id
    private ObjectId id;                        //Doesn't correspond to Item's id. Think about making it the same
    @Field
    private String name;
    @Field
    private double price;
    @Field
    private Date expiry_date;

    public AvailableToBuy(ObjectId id, String name, double price, Date expiry_date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiry_date = expiry_date;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    @Override
    public String toString() {
        return "AvailableToBuy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + moneyFormat.format(price) +
                ", expiry_date=" + expiry_date +
                '}';
    }
}
