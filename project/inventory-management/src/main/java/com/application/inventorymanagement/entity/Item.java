package com.application.inventorymanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.application.inventorymanagement.InventoryManagementApplication.moneyFormat;
import static com.application.inventorymanagement.InventoryManagementApplication.strToDate;

@Document(collection = "item")
public class Item {

    @Id
    private ObjectId id;
    @Field
    private String name;
    @Field
    private double price;
    @Field
    private int total_quantity;
    @Field
    private String last_modified;
    @Field
    private List<Expiration> expiration;

    public Item(){}

    public Item(ObjectId id, String name, double price, int total_quantity, String last_modified, List<Expiration> expiration) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.total_quantity = total_quantity;
        this.last_modified = last_modified;
        if(expiration == null)
            this.expiration = new ArrayList<Expiration>();
        else
            this.expiration = expiration;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public String getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(String last_modified) {
        this.last_modified = last_modified;
    }

    public List<Expiration> getExpiration() {
        return expiration;
    }

    public void setExpiration(List<Expiration> expiration) {
        this.expiration = expiration;
    }

    //if it removed, then it is true; if it did not remove it is false
    public boolean removeEmpty(){
        List<Expiration> tempExp = new ArrayList<>();
        for(Expiration e : expiration){
            if(e.getQuantity() > 0)
                tempExp.add(e);
        }
        if(expiration.equals(tempExp)) return false;
        expiration = tempExp;
        return true;
    }

    public Expiration getExpiration(String requiredExpiration){
        for(Expiration e : expiration){
            if(e.getExpiry_date().equals(requiredExpiration))
                return e;
        }
        throw new IllegalArgumentException("Expiration " + requiredExpiration + "does not exist in " + name);
    }

    public boolean expirationExists(String expirationToCheck){

        for(Expiration e : expiration){
            if(e.getExpiry_date().equals(expirationToCheck)) return true;
        }
        return false;
    }

    private int calculateQuantity(){
        int temp = 0;
        for(Expiration e : expiration){
            temp += e.getQuantity();
        }
        this.total_quantity = temp;
        return total_quantity;
    }
    
    public int removeExpired() throws ParseException {     //returns the quantity of items thrown away
        int removedQuantity = 0;
        List<Expiration> expirations = new ArrayList<Expiration>();

        for(Expiration e : expiration){
            Date expDate = strToDate(e.getExpiry_date());
            if(expDate.before(new Date())){
                removedQuantity += e.getQuantity();
            }else{                  //adds expiration dates that are after today's date
                expirations.add(e);
            }
        }
        expiration = expirations;
        calculateQuantity();
        return removedQuantity;
    }

    //overwrites the old expiration with the new if exists, else inserts
    public Expiration insertExpiration(Expiration e){
        boolean expExists = false;
        int tempIter = 0;
        Expiration temp;
        while(!expExists && expiration != null && tempIter < expiration.size()){
            temp = expiration.get(tempIter);
            if(e.getExpiry_date().equals(temp.getExpiry_date())){
                e.setQuantity(e.getQuantity() + temp.getQuantity());        //makes the new quantity = to old quantity + temp quantity, useful for billing log
                expExists = true;
            }else
                tempIter += 1;
        }
//        temp = expiration.get(tempIter);
        if(expExists){
            expiration.remove(tempIter);
        }
        expiration.add(e);
        calculateQuantity();
        return e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name) &&
                expiration.equals(item.expiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, expiration);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + moneyFormat.format(price) +
                ", total_quantity=" + total_quantity +
                ", last_modified=" + last_modified +
                ", expiration=" + expiration +
                '}';
    }

}
