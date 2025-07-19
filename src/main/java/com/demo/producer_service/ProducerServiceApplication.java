package com.demo.producer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
	scanBasePackages = {"controller", "config", "model"}
)
public class ProducerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerServiceApplication.class, args);
	}

}
