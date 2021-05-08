package com.application.inventorymanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Document(collection = "revenue")
public class Revenue {
    @Id
    private ObjectId id;
    @Field
    private String date;      //date bought
    @Field
    private int item_count;
    @Field
    private double total_cost;
    @Field
    private RevenueType doc_type;        //types that
    @Field
    private List<RevenueItem> item_list;

    public Revenue(){}

    public Revenue(ObjectId id, String date, int item_count, double total_cost, RevenueType doc_type, List<RevenueItem> item_list) {
        this.id = id;
        this.date = date;
        this.item_count = item_count;
        this.total_cost = total_cost;
        this.doc_type = doc_type;
        this.item_list = item_list;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public RevenueType getDoc_type() {
        return doc_type;
    }

    public void setDoc_type(RevenueType doc_type) {
        this.doc_type = doc_type;
    }

    public List<RevenueItem> getItem_list() {
        return item_list;
    }

    public void setItem_list(List<RevenueItem> item_list) {
        this.item_list = item_list;
    }

    public double calculateTotalCost() {
        double tempTotalCost = 0;
        for(RevenueItem ri : item_list){
            tempTotalCost += ( ri.getPrice() * ri.getQuantity() );
        }
        total_cost = tempTotalCost;
        return tempTotalCost;
    }

    public int calculateQuantity(){
        int tempTotalQuantity = 0;
        for(RevenueItem ri : item_list){
            tempTotalQuantity += ri.getQuantity();
        }
        item_count = tempTotalQuantity;
        return tempTotalQuantity;
    }
    @Override
    public String toString() {
        return "Revenue{" +
                "id=" + id +
                ", date=" + date +
                ", item_count=" + item_count +
                ", total_cost=" + total_cost +
                ", doc_type='" + doc_type + '\'' +
                ", item_list=" + item_list +
                '}';
    }


}

