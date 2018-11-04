package com.example.filter;

import com.example.filter.filter.DemoFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@ServletComponentScan
public class FilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilterApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean registrationBean(){
		FilterRegistrationBean filterbean = new FilterRegistrationBean();
		filterbean.setFilter(new DemoFilter());
		filterbean.setName("demofilter");
		filterbean.addUrlPatterns("/hello");
		return filterbean;
	}
}
