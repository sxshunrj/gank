package com.sxshunrj.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/7/19 15:00
 * Desc：
 */
@SpringBootApplication
@MapperScan("com.sxshunrj.test.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
