package com.example.demo;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class DemoFrontendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoFrontendApplication.class, args);
	}

	@GetMapping
	public String helloWorld() throws UnknownHostException {

		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://localhost:8081";
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
		return "Message from backend is: " + response.getBody();
	}

}
