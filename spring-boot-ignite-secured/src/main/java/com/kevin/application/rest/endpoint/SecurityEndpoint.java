package com.kevin.application.rest.endpoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.kevin.application.bean.UserBean;
import com.kevin.application.rest.handler.SecurityHandler;

@Path("/security")
public class SecurityEndpoint {

	@Autowired
	private SecurityHandler securityHandler;
	
	@POST
	@Path("/logout")
	public void logout(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		securityHandler.logout(request, response);
	}
	
	@GET
	@Path("/user")
	@Produces({ MediaType.APPLICATION_JSON })
	public UserBean getUser() {
		return securityHandler.getUser();
	}
}
