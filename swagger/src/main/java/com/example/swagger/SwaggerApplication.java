package com.example.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SwaggerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
}
