import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.*;               //bson filter
import static com.mongodb.client.model.Updates.*;         //Update class

import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;

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
        collection = database.getCollection("item");

        /*
        Two ways to insert documents: using the Document or BasicDBObject
        https://stackoverflow.com/questions/44878605/mongodb-basicdbobject-vs-document-in-java
        Document is better according to stackoverflow
         */

        /*
        https://mongodb.github.io/mongo-java-driver/4.2/driver/tutorials/perform-write-operations/ ~ write and update documents
        If no top-level _id field is specified in the document, the Java driver automatically adds the _id field to the inserted document.

        new Date() and currentDate(field) give the same output, currentDate is meant for BSON
        */
        Document document = new Document("name", "banana").append("count", 100).append("price","$3.00").append("lastModified", new Date());
        //collection.insertOne(document);                                                   //insert a new document, WILL STILL CREATE NEW DOCUMENT EVEN IF IT EXISTS: new id will be generated
        //collection.findOneAndReplace(eq("name","banana"), document);                      //update document with a new document

        /*
        https://mongodb.github.io/mongo-java-driver/4.2/driver/tutorials/perform-write-operations/
        https://mongodb.github.io/mongo-java-driver/4.1/builders/filters/ ~ bson filters
        updates a document
        */
        collection.updateOne(eq("name", "banana"), combine(inc("count", -10), set("price", "$2.69"), currentDate("lastModified")));

        /*
        find by id by using eq function and "new ObjectId(<id>)
         */
        //collection.findOneAndDelete(eq("_id", new ObjectId("6065521cac7af6475fadd2a1")));

        /*
        https://www.tutorialspoint.com/how-to-retrieve-all-the-documents-from-a-mongodb-collection-using-java
         */
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
