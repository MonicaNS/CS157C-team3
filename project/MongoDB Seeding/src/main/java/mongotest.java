import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.bson.types.ObjectId;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.*;               //bson filter
import static com.mongodb.client.model.Updates.*;         //Update class
import static java.util.Arrays.asList;

import java.lang.reflect.Array;
import java.net.UnknownHostException;
import java.util.*;

public class mongotest {
    public static MongoClient mongoClient;
    public static MongoClientURI mongoClientURI;
    public static MongoDatabase database;
    public static MongoCollection collection;
    public static void main(String[] args) {
        String uri = "mongodb+srv://example:example@inv-mgmt.txqen.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
        mongoClientURI = new MongoClientURI(uri);
        mongoClient = MongoClients.create(uri);
        database = mongoClient.getDatabase("inventory-management");
        collection = database.getCollection("available_to_buy");

        Document availableToBuy1 = new Document("name", "milk")
                .append("price", 0.20)
                .append("expiry_date", new Date(121, 5, 17));
        Document availableToBuy2 = new Document("name", "eggs")
                .append("price", 0.20)
                .append("expiry_date", new Date(121, 5, 25));
        Document availableToBuy3 = new Document("name", "chips")
                .append("price", 0.15)
                .append("expiry_date", null);
        Document availableToBuy4 = new Document("name", "cheese")
                .append("price", 0.40)
                .append("expiry_date", null);
        Document availableToBuy5 = new Document("name", "wine")
                .append("price", 3.00)
                .append("expiry_date", new Date(121, 7, 10));
        Document availableToBuy6 = new Document("name", "soda")
                .append("price", 0.40)
                .append("expiry_date", new Date(121, 6, 07));
        Document availableToBuy7 = new Document("name", "salsa")
                .append("price", 0.30)
                .append("expiry_date", new Date(121, 5, 29));
        Document availableToBuy8 = new Document("name", "candy")
                .append("price", 0.07)
                .append("expiry_date", null);
        Document availableToBuy9 = new Document("name", "juice")
                .append("price", 0.70)
                .append("expiry_date", new Date(121, 6, 14));
        Document availableToBuy10 = new Document("name", "strawberry juice")
                .append("price", 0.65)
                .append("expiry_date", new Date(121, 6, 14));

        List<Document> inventoryList = new ArrayList<>();
        inventoryList.add(availableToBuy1);
        inventoryList.add(availableToBuy2);
        inventoryList.add(availableToBuy3);
        inventoryList.add(availableToBuy4);
        inventoryList.add(availableToBuy5);
        inventoryList.add(availableToBuy6);
        inventoryList.add(availableToBuy7);
        inventoryList.add(availableToBuy8);
        inventoryList.add(availableToBuy9);
        inventoryList.add(availableToBuy10);
        collection.insertMany(inventoryList);

        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

//        collection = database.getCollection("item");

//        Document item1 = new Document("name", "milk")
//                .append("price", 3.49)
//                .append("total quantity",60)
//                .append("lastModified", new Date())
//                .append("expiration", asList(   new Document("expiry date", new Date(2021, 4, 20)).append("quantity",20),
//                        new Document("expiry date", new Date(2021, 4, 25)).append("quantity",40)));
//        Document item2 = new Document("name", "banana")
//                .append("price", 2.49)
//                .append("total quantity", 42)
//                .append("lastModified", new Date())
//                .append("expiration", asList(   new Document("expiry date", new Date(2021, 4, 14)).append("quantity",10),
//                        new Document("expiry date", new Date(2021, 4, 16)).append("quantity",32)));
//        Document item3 = new Document("name","eggs")
//                .append("price", 2.68)
//                .append("total quantity", 10)
//                .append("lastModified", new Date())
//                .append("expiration", asList(   new Document("expiry date", new Date(2021, 4, 10)).append("quantity",10)));
//        Document item4 = new Document("name","chips")
//                .append("price", 3.64)
//                .append("total quantity", 20)
//                .append("lastModified", new Date());
//        Document item5 = new Document("name","cheese")
//                .append("price", 5.99)
//                .append("total quantity", 15)
//                .append("lastModified", new Date())
//                .append("expiration", asList(new Document("expiry date", new Date(2021, 6, 20)).append("quantity",15)));
//        Document item6 = new Document("name","wine")
//                .append("price", 10.99)
//                .append("total quantity", 6)
//                .append("lastModified", new Date());
//        Document item7 = new Document("name","soda")
//                .append("price", 3.99)
//                .append("total quantity", 17)
//                .append("lastModified", new Date())
//                .append("expiration", asList(new Document("expiry date", new Date(2022, 4, 4)).append("quantity",17)));
//        Document item8 = new Document("name","salsa")
//                .append("price", 2.99)
//                .append("total quantity", 8)
//                .append("lastModified", new Date())
//                .append("expiration", asList(new Document("expiry date", new Date(2021, 7, 8)).append("quantity",8)));
//        Document item9 = new Document("name","candy")
//                .append("price", 2.35)
//                .append("total quantity", 9)
//                .append("lastModified", new Date());
//        Document item10 = new Document("name","juice")
//                .append("price", 3.99)
//                .append("total quantity", 10)
//                .append("lastModified", new Date())
//                .append("expiration", asList(new Document("expiry date", new Date(2021, 6, 10)).append("quantity",10)));
//
//        List<Document> inventoryList = new ArrayList<>();
//        inventoryList.add(item1);
//        inventoryList.add(item2);
//        inventoryList.add(item3);
//        inventoryList.add(item4);
//        inventoryList.add(item5);
//        inventoryList.add(item6);
//        inventoryList.add(item7);
//        inventoryList.add(item8);
//        inventoryList.add(item9);
//        inventoryList.add(item10);
//        collection.insertMany(inventoryList);
//
//        FindIterable<Document> iterDoc = collection.find();
//        Iterator it = iterDoc.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//
//        collection = database.getCollection("billing_log");
//        Document bill1 = new Document("order date", new Date(2021, 3, 29))
//                .append("total quantity", 72)
//                .append("total cost", 9.60)
//                .append("order_list", asList(new Document("name","milk").append("quantity",40).append("price", 0.20),
//                        new Document("name", "banana").append("quantity", 32).append("price",0.05)));
//        Document bill2 = new Document("order date", new Date(2021, 3, 28))
//                .append("total quantity", 10)
//                .append("total cost", 2.00)
//                .append("order_list", asList(new Document("name","eggs").append("quantity",10).append("price", 0.20)));
//        Document bill3 = new Document("order date", new Date(2021, 3, 27))
//                .append("total quantity", 35)
//                .append("total cost", 9.00)
//                .append("order_list", asList(new Document("name","chips").append("quantity",20).append("price", 0.15),
//                        new Document("name", "cheese").append("quantity", 15).append("price", 0.40)));
//        Document bill4 = new Document("order date", new Date(2021, 3, 26))
//                .append("total quantity", 23)
//                .append("total cost", 24.80)
//                .append("order_list", asList(new Document("name","wine").append("quantity",6).append("price", 3.00),
//                        new Document("name", "soda").append("quantity", 17).append("price", 0.40)));
//        Document bill5 = new Document("order date", new Date(2021, 3, 25))
//                .append("total quantity", 17)
//                .append("total cost", 3.03)
//                .append("order_list", asList(new Document("name","salsa").append("quantity",8).append("price", 0.30),
//                        new Document("name", "candy").append("quantity", 9).append("price", 0.07)));
//        Document bill6 = new Document("order date", new Date(2021, 3, 24))
//                .append("total quantity", 10)
//                .append("total cost", 1.20)
//                .append("order_list", asList(new Document("name","salsa").append("quantity",8).append("price", 0.15)));
//        List<Document> billList= new ArrayList<>();
//        billList.add(bill1);
//        billList.add(bill2);
//        billList.add(bill3);
//        billList.add(bill4);
//        billList.add(bill5);
//        billList.add(bill6);
//        collection.insertMany(billList);
//
//        iterDoc = collection.find();
//        it = iterDoc.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
    }
}
