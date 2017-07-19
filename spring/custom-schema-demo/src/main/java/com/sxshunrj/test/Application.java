package com.sxshunrj.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/19 15:00
 * Desc：
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);

        ApplicationContext ctx = new ClassPathXmlApplicationContext("test.xml");
        People people1 = (People) ctx.getBean("people1");

        System.out.println(people1);

    }
}
