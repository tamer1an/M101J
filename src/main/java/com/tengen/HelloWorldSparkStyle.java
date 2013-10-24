package com.tengen;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created with IntelliJ IDEA.
 * User: Andrii
 * Date: 24.10.13
 * Time: 22:51
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldSparkStyle {
    public static  void main(String[] args){
      Spark.get(new Route("/") {
          @Override
          public Object handle(Request request, Response response) {
              return "Hello world sparks";
          }
      });
   }
}
