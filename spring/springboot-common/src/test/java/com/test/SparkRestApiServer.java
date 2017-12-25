//package com.test;
//
//import spark.Filter;
//import spark.Request;
//import spark.Response;
//
//import javax.servlet.http.HttpServletRequest;
//
//import static spark.Spark.*;
//
///**
// * Created by IntelliJ IDEA.
// * User: sunxs
// * Date: 2017/12/22 17:46
// * Desc： compile group: 'com.sparkjava', name: 'spark-core', version: '2.3'
// */
//public class SparkRestApiServer {
//    public static void main(String[] args) {
//        ipAddress("192.168.10.70");
//        port(9900);
//
////        before(new Filter() {
////            @Override
////            public void handle(Request request, Response response) throws Exception {
////                HttpServletRequest req = (HttpServletRequest) request;
////                System.out.println("url:"+req.getRequestURL().toString());
////            }
////        });
//        get("/hello", (req, res) ->
//                "Hello World"
//        );
//    }
//}
