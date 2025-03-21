package com.demo.circuitbreakerclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.circuitbreakerclient.bookservice.BookService;

@SpringBootApplication
@RestController
public class ReadingserviceApplication {

	@Autowired
	private BookService service;
	
	@Bean
	public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	@GetMapping("/retrieve")
	public String retrieveList() {
		return service.readingList();
	}
	public static void main(String[] args) {
		SpringApplication.run(ReadingserviceApplication.class, args);
	}

}