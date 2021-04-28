package com.application.inventorymanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

import static com.application.inventorymanagement.InventoryManagementApplication.moneyFormat;

@Document(collection = "net_income")
public class NetIncome {
    @Id
    private ObjectId id;
    @Field
    private double gross;               //total amount customers bought from us
    @Field
    private double loss_bought;         //total amount we bought from wholesale
    @Field
    private double loss_expired;        //total amount of items loss expired
    @Field
    private Date last_modified;

    public NetIncome(ObjectId id, double gross, double loss_bought, double loss_expired, Date last_modified) {
        this.id = id;
        this.gross = gross;
        this.loss_bought = loss_bought;
        this.loss_expired = loss_expired;
        this.last_modified = last_modified;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public double getLoss_bought() {
        return loss_bought;
    }

    public void setLoss_bought(double loss_bought) {
        this.loss_bought = loss_bought;
    }

    public double getLoss_expired() {
        return loss_expired;
    }

    public void setLoss_expired(double loss_expired) {
        this.loss_expired = loss_expired;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }

    @Override
    public String toString() {
        return "NetIncome{" +
                "id=" + id +
                ", gross=" + gross +
                ", loss_bought=" + loss_bought +
                ", loss_expired=" + loss_expired +
                ", last_modified=" + last_modified +
                '}';
    }
}
