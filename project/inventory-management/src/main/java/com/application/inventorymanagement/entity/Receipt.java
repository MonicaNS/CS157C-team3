package com.application.inventorymanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.Date;

import static com.application.inventorymanagement.InventoryManagementApplication.moneyFormat;

@Document(collection = "receipt")
public class Receipt {
    @Id
    private ObjectId id;
    @Field
    private Date date;      //date bought
    @Field
    private int item_count;
    @Field
    private double total_cost;
    @Field
    private ReceiptItem[] item_list;

    public Receipt(ObjectId id, Date date, int item_count, double total_cost, ReceiptItem[] item_list) {
        this.id = id;
        this.date = date;
        this.item_count = item_count;
        this.total_cost = total_cost;
        this.item_list = item_list;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public ReceiptItem[] getItem_list() {
        return item_list;
    }

    public void setItem_list(ReceiptItem[] item_list) {
        this.item_list = item_list;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", date=" + date +
                ", item_count=" + item_count +
                ", total_cost=" + moneyFormat.format(total_cost) +
                ", item_list=" + Arrays.toString(item_list) +
                '}';
    }
}
