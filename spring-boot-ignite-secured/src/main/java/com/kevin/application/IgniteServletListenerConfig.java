package com.kevin.application;

import javax.servlet.ServletContextListener;

import org.apache.ignite.startup.servlet.ServletContextListenerStartup;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteServletListenerConfig {

	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> servletListenerRegistration() {
		final ServletListenerRegistrationBean<ServletContextListener> registration = 
				new ServletListenerRegistrationBean<> ();
		
		registration.setOrder(1);
		registration.setListener(webSessionServletListener());
		return registration;
	}
	
	public ServletContextListener webSessionServletListener() {
		return new ServletContextListenerStartup();
	}
}
