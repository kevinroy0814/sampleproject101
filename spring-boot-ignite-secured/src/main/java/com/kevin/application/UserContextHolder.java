package com.kevin.application;

import javax.ws.rs.NotAuthorizedException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.kevin.application.bean.UserBean;
import com.kevin.application.domain.User;

public class UserContextHolder {

	public static final UserBean getUser() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null && authentication instanceof UsernamePasswordAuthenticationToken) {
			return (UserBean) authentication.getPrincipal();
		} else {
			throw new NotAuthorizedException("User is not authenticated.");
		}
	}
	
	public static final void refreshUser(User user) {
		getUser().setUser(user);
	}
}
