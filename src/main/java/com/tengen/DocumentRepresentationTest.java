package com.tengen;

import com.mongodb.BasicDBObject;

import java.util.Arrays;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Andrii
 * Date: 29.10.13
 * Time: 22:26
 * To change this template use File | Settings | File Templates.
 */
public class DocumentRepresentationTest {
    public static void main(String[] args) {
         BasicDBObject doc = new BasicDBObject();
         doc.put("userName","tav");
         doc.put("birthData",new Date());
         doc.put("programer",true);
         doc.put("age",8);
         doc.put("lanaguage", Arrays.asList("java", "js"));
         doc.put("adress", new BasicDBObject("street", "20 Main")
                                     .append("town"  , "kiev")
                                     .append("zip"   , "00000"));


    }
}
