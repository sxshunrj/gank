package com.sxshunrj.springcloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 1、Windows增加DOCKER_HOST环境变量
 * 			DOCKER_HOST：tcp://192.168.10.183:2375
 * 2、mvn clean package docker:build -DskipTests -X
 *
 * http://www.cnblogs.com/cocoat/p/7473785.html
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
