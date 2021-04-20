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
    private String itemName;
    @Field
    private double price;
    @Field
    private int totalQuantity;
    @Field
    private Date lastModified;
    private Expiration[] expiredList;

    public Item() {

    }

    public Item(String id, String itemName, double price, int totalQuantity, Date lastModified, Expiration[] expiredList) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.totalQuantity = totalQuantity;
        this.lastModified = lastModified;
        this.expiredList = expiredList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
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
        return "Inventory [id=" + id + ", itemName=" + itemName + ", price=" + price + ", totalQuantity="
                + totalQuantity + ", lastModified=" + lastModified + ", expiredList=" + expiredList + "]";
        //Date was removed for now
    }

}
