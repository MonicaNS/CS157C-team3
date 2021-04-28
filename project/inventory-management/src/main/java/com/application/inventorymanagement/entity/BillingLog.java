package com.application.inventorymanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.application.inventorymanagement.InventoryManagementApplication.moneyFormat;

@Document(collection = "billing_log")
public class BillingLog {
    @Id
    private ObjectId id;
    @Field
    private Date order_date;
    @Field
    private int total_quantity;
    @Field
    private double total_cost;
    @Field
    private List<BillingItem> order_list;


    public BillingLog(ObjectId id, Date order_date, int total_quantity, double total_cost, List<BillingItem> order_list) {
        this.id = id;
        this.order_date = order_date;
        this.total_quantity = total_quantity;
        this.total_cost = total_cost;
        this.order_list = order_list;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public List<BillingItem> getOrder_list() {
        return order_list;
    }

    public void setOrder_list(List<BillingItem> order_list) {
        this.order_list = order_list;
    }

    public double calculateCost(){
        double temp = 0;
        for(BillingItem bi : order_list){
            temp += bi.getPrice() * bi.getQuantity();
        }
        total_cost = temp;
        return temp;
    }

    public int calculateQuantity(){
        int temp = 0;
        for(BillingItem bi : order_list){
            temp += bi.getQuantity();
        }
        total_quantity = temp;
        return temp;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", total_quantity=" + total_quantity +
                ", total_cost=" + moneyFormat.format(total_cost) +
                ", order_list=" + order_list +
                '}';
    }
}
