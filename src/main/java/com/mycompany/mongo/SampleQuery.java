package com.mycompany.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.Arrays;

public class SampleQuery {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    public static void main(String args[]) {
        try {
            MongoCredential credential = MongoCredential.createCredential("administrator","admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));
            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");
//            DBObject query = new BasicDBObject("name", "owen");//filtrando
//            DBObject query = new
//             BasicDBObject("name", new BasicDBObject("$ne","owen")).append("age", new BasicDBObject("$gt", 10));//filtrando

//            DBCursor cursor = coll.find(query);//filtrando
            DBCursor cursor = coll.find();
            try {
                while (cursor.hasNext()) {
                    DBObject object = cursor.next();
                    System.out.println(object);
                }
            } finally {
                cursor.close();
            }

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
    }
}
