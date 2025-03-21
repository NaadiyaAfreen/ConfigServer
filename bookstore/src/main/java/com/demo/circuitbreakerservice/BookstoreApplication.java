package com.demo.circuitbreakerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookstoreApplication {

	@RequestMapping("/recommended")
	public String readingList() {
		return "Spring in Action, Learn CiruitBreaker Design Pattern, Learning Spring Boot";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
