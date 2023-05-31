package com.cris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.cris, com.irctc")
public class CrisSpringBootApplication {

	public static void main(String[] args) {
		
		System.setProperty("server.port", "9091");
		
		SpringApplication.run(CrisSpringBootApplication.class, args);
	}

}
