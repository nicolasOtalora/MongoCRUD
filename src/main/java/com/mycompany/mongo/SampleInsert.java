/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongo;

/**
 *
 * @author brown
 */
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import java.util.Arrays;

public class SampleInsert {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    public static void main(String args[]) {
        try {

           MongoCredential credential = MongoCredential.createCredential("administrator","admin", "mypassword".toCharArray());

            MongoClient mongoClient = new MongoClient(new ServerAddress("localhost"), Arrays.asList(credential));

            DB db = mongoClient.getDB("sampledb");

            DBCollection coll = db.getCollection("javastuff");
            DBObject doc = new BasicDBObject("name", "owen")
                    .append("age", 47)
                    .append("email", "owen@mail.com")
                    .append("phone", "111-222-333");

            coll.insert(doc);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "
                    + e.getMessage());
        }
    }
}
