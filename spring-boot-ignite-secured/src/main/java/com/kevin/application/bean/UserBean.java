package com.kevin.application.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.kevin.application.domain.User;

public class UserBean extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = -1653103404363381254L;
	
	private User user;
	
	public UserBean(String username, String password, Collection<? extends GrantedAuthority> authorities, User user) {
		super(username, password, authorities);
		setUser(user);
	}
	
	public User getUserEntity() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUserId() {
		return user.getUserId();
	}
	
	public String getFirstName() {
		return user.getFirstName();
	}
	
	public String getLastName() {
		return user.getLastName();
	}
	
	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}
}
