package com.sxshunrj.kafka.consumer

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.Banner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/16 15:55
 * Desc：
 */
@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application)

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class)
        app.bannerMode = Banner.Mode.CONSOLE
        app.run args
    }
}
