package com.application.inventorymanagement.entity;

import java.util.Date;
import java.util.List;

public class WholesalePurchase {
    private Date orderDate;
    private List<WholesaleItem> wholesaleItems;

    public WholesalePurchase(Date orderDate, List<WholesaleItem> wholesaleItems) {
        this.orderDate = orderDate;
        this.wholesaleItems = wholesaleItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<WholesaleItem> getWholesaleItems() {
        return wholesaleItems;
    }

    public void setWholesaleItems(List<WholesaleItem> wholesaleItems) {
        this.wholesaleItems = wholesaleItems;
    }

    @Override
    public String toString() {
        return "WholesalePurchase{" +
                "orderDate=" + orderDate +
                ", wholesaleItems=" + wholesaleItems +
                '}';
    }
}
