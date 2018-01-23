package com.sxshunrj.springcloud.configclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@Value("${foo}")
	String foo;

	@Value("${name}")
	String name;

	@Value("${age}")
	Integer age;

	@RequestMapping(value = "/hi")
	public String hi(){
		System.out.println("config-client...");
		System.out.println("foo:"+foo);
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		return foo + name + age;
	}

}
