package com.application.inventorymanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "item")
public class Item {

    @Id
    private String id;
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

    public Item(String id, String name, double price, int total_quantity, Date last_modified, Expiration[] expiration) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.total_quantity = total_quantity;
        this.last_modified = last_modified;
        this.expiration = expiration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String name) {
        this.name = name;
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

//	public Date getLastModified() {
//		return lastModified;
//	}
//
//	public void setLastModified(Date lastModified) {
//		this.lastModified = lastModified;
//	}

    @Override
    public String toString() {
        return "Inventory [id=" + id + ", name=" + name + ", price=" + price + ", total_quantity="
                + total_quantity + ", last_modified=" + last_modified + ", expired_list=" + expiredToString() + "]";
        //Date was removed for now
    }
    private String expiredToString(){
        if (expiration == null)
            return null;
        String temp = "[";
        for(int i = 0; i < expiration.length; i++){
            temp += expiration[i];
            if(i <= expiration.length-2){
                temp += ",";
            }else{
                temp += "]";
            }
        }
        return temp;
    }
}
