package com.application.inventorymanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.Date;

@Document(collection = "billing_log")
public class Billing {
    @Id
    private ObjectId id;
    @Field
    private Date order_date;
    @Field
    private int total_quantity;
    @Field
    private double total_cost;
    @Field
    private BillingItem[] order_list;

    public Billing(ObjectId id, Date order_date, int total_quantity, double total_cost, BillingItem[] order_list) {
        this.id = id;
        this.order_date = order_date;
        this.total_quantity = total_quantity;
        this.total_cost = total_cost;
        this.order_list = order_list;
    }

    public ObjectId getId() {        return id;    }

    public void setId(ObjectId id) {        this.id = id;    }

    public Date getOrder_date() {        return order_date;    }

    public void setOrder_date(Date order_date) {        this.order_date = order_date;    }

    public int getTotal_quantity() {        return total_quantity;    }

    public void setTotal_quantity(int total_quantity) {        this.total_quantity = total_quantity;    }

    public double getTotal_cost() {        return total_cost;    }

    public void setTotal_cost(double total_cost) {        this.total_cost = total_cost;    }

    public BillingItem[] getOrder_list() {        return order_list;    }

    public void setOrder_list(BillingItem[] order_list) {        this.order_list = order_list;    }

    @Override
    public String toString() {
        return "Billing{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", total_quantity=" + total_quantity +
                ", total_cost=" + total_cost +
                ", order_list=" + Arrays.toString(order_list) +
                '}';
    }
}
