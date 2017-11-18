package com.kevin.application.rest.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kevin.application.bean.UserBean;

public interface SecurityHandler {

	void logout(HttpServletRequest request, HttpServletResponse response);
	
	UserBean getUser();
}
