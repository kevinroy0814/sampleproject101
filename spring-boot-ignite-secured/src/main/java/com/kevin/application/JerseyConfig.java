package com.kevin.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.kevin.application.rest.endpoint.SecurityEndpoint;

@Component
@ApplicationPath("services")
public class JerseyConfig extends ResourceConfig {
	
	public JerseyConfig() {
		//
		
		// Register End Points
		register(SecurityEndpoint.class);
	}
}
