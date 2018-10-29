package com.example.listener;

import com.example.listener.custom.DemoListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextListener;

@SpringBootApplication
@ServletComponentScan
public class ListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListenerApplication.class, args);
	}

//	@Bean
//	public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean(){
//		ServletListenerRegistrationBean listenerRegistrationBean= new ServletListenerRegistrationBean();
//		listenerRegistrationBean.setListener(new DemoListener());
//		return listenerRegistrationBean;
//	}
}
