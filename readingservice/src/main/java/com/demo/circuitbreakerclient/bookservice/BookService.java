package com.demo.circuitbreakerclient.bookservice;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class BookService {

	@Autowired
    private RestTemplate restTemplate;
	
	private static final String READING_SERVICE = "reading-service";

@CircuitBreaker(name=READING_SERVICE,fallbackMethod="reliable")
public String readingList() {
 URI uri = URI.create("http://localhost:9005/recommended");
 return restTemplate.getForObject(uri, String.class);
}

public String reliable(Exception exception) {
    return "Cloud Native Java (O'Reilly)";
}
}
