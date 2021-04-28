package com.example.mongo.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.example.mongo.entity.Inventory;
import com.example.mongo.repository.InventoryRepository;
import java.util.List;

@SpringBootApplication
public class SpringMongoApplication  implements CommandLineRunner{
	
	@Autowired
	private InventoryRepository inventoryRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Inventory item = new Inventory("1", "Banana", 1.0, 3 );
		Inventory item2 = new Inventory("2", "milk", 1.0, 3 );
		Inventory item3 = new Inventory("1", "moreBanana", 1.0, 3 );
		
		
		inventoryRepo.save(item);
		inventoryRepo.save(item2);
		inventoryRepo.save(item3);
		
		System.out.println("Customers save ");
		
		List <Inventory> i = inventoryRepo.findAll();
		
		for(Inventory items: i ) {
			System.out.println(items.toString());
		}
		
				
		
	}

}
