package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Andrii
 * Date: 30.10.13
 * Time: 2:12
 * To change this template use File | Settings | File Templates.
 */
public class FindTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB courseDB = client.getDB("course");
        DBCollection collection = courseDB.getCollection("insertTest");
        collection.drop();

        for (int i = 0; i < 10; i++) {
            collection.insert(new BasicDBObject("x",new Random().nextInt(100)));
        }

        DBObject one = collection.findOne();
        System.out.println("Find one: "+one);

        System.out.println("Find all:");
        DBCursor cursor = collection.find();

        try{
          while(cursor.hasNext()){
              DBObject cur = cursor.next();
              System.out.println(cur);
          }
        } finally {
            cursor.close();
        }

        long count = collection.count();
        System.out.println("Count: "+count);
    }
}
