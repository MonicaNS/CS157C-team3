package com.application.inventorymanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import com.application.inventorymanagement.entity.Item;
import com.application.inventorymanagement.repository.ItemRepository;
import java.util.List;

@SpringBootApplication
public class InventoryManagementApplication implements CommandLineRunner {


    private ItemRepository itemRepository;

    @Autowired
    public InventoryManagementApplication(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(InventoryManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

		Item item = new Item("1", "Banana", 1.0, 3 );
		Item item2 = new Item("2", "milk", 1.0, 3 );
		Item item3 = new Item("3", "moreBanana", 1.0, 3 );
//
//
		itemRepository.save(item);
		itemRepository.save(item2);
		itemRepository.save(item3);

		System.out.println("Customers save ");

        List <Item> i = itemRepository.findAll();

        for(Item items: i ) {
            System.out.println(items.toString());
        }



    }
}
