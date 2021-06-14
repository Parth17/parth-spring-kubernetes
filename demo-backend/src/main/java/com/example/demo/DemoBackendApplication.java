package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class DemoBackendApplication {
	
	@Value("${my.name}")
	private String name;

	public static void main(String[] args) {
		SpringApplication.run(DemoBackendApplication.class, args);
	}
	
	@GetMapping("")
    public String helloWorld() throws UnknownHostException {
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
	    String strDate= formatter.format(date); 

	    return strDate +" Hello "+ name;
    }

}
