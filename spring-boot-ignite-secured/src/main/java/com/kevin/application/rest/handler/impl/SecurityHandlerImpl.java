package com.kevin.application.rest.handler.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.application.UserContextHolder;
import com.kevin.application.bean.UserBean;
import com.kevin.application.rest.handler.SecurityHandler;

@Transactional
@Component
public class SecurityHandlerImpl implements SecurityHandler {

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
	}

	@Override
	public UserBean getUser() {
		return UserContextHolder.getUser();
	}
}
