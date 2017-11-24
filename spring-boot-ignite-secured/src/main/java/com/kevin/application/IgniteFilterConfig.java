package com.kevin.application;

import javax.servlet.Filter;

import org.apache.ignite.cache.websession.WebSessionFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteFilterConfig {

	@Bean
	public FilterRegistrationBean filterRegistration() {
		final FilterRegistrationBean registration = new FilterRegistrationBean();
		
		registration.addInitParameter("IgniteWebSessionsCacheName", "session-cache");
		registration.addInitParameter("IgniteWebSessionsGridName", "session-grid");
		registration.setFilter(webSessionFilter());
		registration.addUrlPatterns("/*");
		registration.setName("webSessionFilter");
		registration.setOrder(1);

		return registration;
	}
	
	public Filter webSessionFilter() {
		return new WebSessionFilter();
	}
}
