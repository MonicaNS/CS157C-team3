package com.application.inventorymanagement.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Objects;

/**
 * Subclass for Item, Expiration array
 */
public class Expiration {
    @Field
    private Date expiry_date;
    @Field
    private int quantity;

    public Expiration(Date expiry_date, int quantity) {
        this.expiry_date = expiry_date;
        this.quantity = quantity;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Expiration{" +
                "expiry_date=" + expiry_date +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expiration that = (Expiration) o;
        return quantity == that.quantity &&
                expiry_date.equals(that.expiry_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expiry_date, quantity);
    }
//    @Override
//    public String toString(){
//        return "[expiry_date=" + expiry_date + ", quantity=" + quantity + "]";
//    }
}