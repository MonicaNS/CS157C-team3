package com.application.inventorymanagement;

import com.application.inventorymanagement.controller.*;
import com.application.inventorymanagement.entity.*;
import com.application.inventorymanagement.repository.*;
import com.application.inventorymanagement.service.*;
import org.bson.types.ObjectId;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class InventoryManagementApplication implements CommandLineRunner {
    public static DecimalFormat moneyFormat = new DecimalFormat("$0.00");

    public static ItemService itemService;
    public static BillingLogService billingLogService;
    public static AvailableToBuyService availableToBuyService;
    public static RevenueService revenueService;

    @Autowired
    public InventoryManagementApplication(ItemRepository itemRepository,
                                          BillingLogRepository billingLogRepository,
                                          AvailableToBuyRepository availableToBuyRepository,
                                          RevenueRepository revenueRepository) {
        this.itemService = new ItemService(itemRepository);
        this.billingLogService = new BillingLogService(billingLogRepository);
        this.availableToBuyService = new AvailableToBuyService(availableToBuyRepository);
        this.revenueService = new RevenueService(revenueRepository);
    }

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }

    public static String dateToStr(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss");
        String dateStr = dateFormat.format(date);
        return dateStr;
    }
    public static Date strToDate(String date) throws ParseException {
        SimpleDateFormat Date = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss");
        Date newDate = Date.parse(date);
        return newDate;
    }
}
