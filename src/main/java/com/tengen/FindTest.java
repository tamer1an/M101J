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
            collection.insert(new BasicDBObject("x", new Random().nextInt(2))
                    .append("y", new Random().nextInt(100))
                    .append("z", new Random().nextInt(1000)));
        }

        DBObject query = new BasicDBObject("x",0)
                .append("y", new BasicDBObject("$gt",10).append("$lt",90));

        DBObject one = collection.findOne();
        System.out.println("Find one: "+one);

        System.out.println("Find all:");
//        DBCursor cursor = collection.find(query,new BasicDBObject("x",false));
        DBCursor cursor = collection.find(query,new BasicDBObject("y",true).append("_id",false))
                                    .sort(new BasicDBObject("_id",-1))
                                    .skip(2);

        try{
          while(cursor.hasNext()){
              DBObject cur = cursor.next();
              System.out.println(cur);
          }
        } finally {
            cursor.close();
        }

        QueryBuilder builder = QueryBuilder.start("x").is(0)
                                            .and("y")
                                            .greaterThan(10)
                                            .lessThan(70);

        long count = collection.count(builder.get());
        System.out.println("Count: "+count);

        collection.update(new BasicDBObject("_id","alice"),new BasicDBObject("age",30));
        collection.update(
                new BasicDBObject("_id","alice"),
                new BasicDBObject("$set", new BasicDBObject("age",30))
                ,true   /* upsert */
                ,false  /* multi  */
        );

        collection.remove(new BasicDBObject("_id", "alice")); // remove every matching document
    } 
    public static int getRange(String id, int range, DBCollection collection){
        DBObject doc = collection.findAndModify(
                new BasicDBObject("_id",id),
                null, // filds get back
                null, // sort
                false,// remove
                new BasicDBObject("$inc", new BasicDBObject("counter",range)), //update
                true, // return neww
                true  // upsert
        );
        return (Integer) doc.get("counter");
    }
}
