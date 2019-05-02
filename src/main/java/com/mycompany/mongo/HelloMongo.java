/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 *
 * @author brown
 */
public class HelloMongo {

    private final static String HOST = "localhost";
    private final static int PORT = 27017;

    public static void main(String args[]) {
        try {
            // Connect to mongodb server on localhost
            MongoClient mongoClient = new MongoClient(HOST,  PORT);
            DB db = mongoClient.getDB("test");
            System.out.println("Successfully connected to MongoDB   ");
        }
        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": "   + e.getMessage());
        }
    }
}
