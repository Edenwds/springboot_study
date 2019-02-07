package com.example.log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Log4j2Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Log4j2Application.class, args);
	}
}
