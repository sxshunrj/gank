package com.sxshunrj.springcloud.servicefeign;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        System.out.println("service-feign");
        return schedualServiceHi.sayHiFromClientOne(name);
    }


}