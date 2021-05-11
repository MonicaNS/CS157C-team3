package com.application.inventorymanagement.entity;

import java.util.Arrays;

public class Stats {
    private String itemName;
    private double[] data;

    public  Stats(){
    }

    public Stats(String itemName, double[] data){
        this.itemName = itemName;
        this.data = data;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double[] getData() {
        return data;
    }

    public void setData(double[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "itemName='" + itemName + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

}
