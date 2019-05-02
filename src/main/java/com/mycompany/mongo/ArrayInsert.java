package com.mycompany.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ArrayInsert {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    public static void main(String args[]) {
        try {
            MongoCredential credential = MongoCredential.createCredential("administrator","admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));

            DB db = mongoClient.getDB("sampledb");
            DBCollection coll = db.getCollection("javastuff");
            List<DBObject> kids = new ArrayList<>();
            kids.add(new BasicDBObject("name", "mike"));
            kids.add(new BasicDBObject("name", "faye"));
            DBObject doc = new BasicDBObject("name", "john")
                    .append("age", 35)
                    .append("kids", kids)
                    .append("info",
                            new BasicDBObject("email", "john@mail.com")
                                    .append("phone", "876-134-667"));
            coll.insert(doc);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
    }
}
