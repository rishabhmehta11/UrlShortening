package com.neueda.urlshortening.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class NeuedaUrlShorteningApplication {

	//Main method
	public static void main(String[] args) {
		//running as a spring boot application
		SpringApplication.run(NeuedaUrlShorteningApplication.class, args);
	}

}
