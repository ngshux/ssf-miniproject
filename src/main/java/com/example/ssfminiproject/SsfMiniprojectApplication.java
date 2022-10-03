package com.example.ssfminiproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SsfMiniprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsfMiniprojectApplication.class, args);
	}

}
