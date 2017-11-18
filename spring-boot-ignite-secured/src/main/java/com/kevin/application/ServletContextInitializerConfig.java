package com.kevin.application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletContextInitializerConfig {

	@Bean
	public ServletContextInitializer initializer() {
	    return new ServletContextInitializer() {
	        @Override
	        public void onStartup(ServletContext servletContext) throws ServletException {
	            servletContext.setInitParameter("IgniteConfigurationFilePath", "spring/ignite-cache.xml");
	        }
	    };
	}
}
