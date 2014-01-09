package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Andrii
 * Date: 30.10.13
 * Time: 1:48
 * To change this template use File | Settings | File Templates.
 */
public class InsertTest {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB courseDB = client.getDB("course");
        DBCollection collection = courseDB.getCollection("insertTest");
        collection.drop();

        DBObject doc = new BasicDBObject().append("x",1);
        DBObject doc2 = new BasicDBObject().append("x",2);

        System.out.println(doc);
        collection.insert(Arrays.asList(doc,doc2));
    }
}
