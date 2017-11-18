package com.kevin.application.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kevin.application.bean.UserBean;
import com.kevin.application.domain.User;

@Transactional
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();
        
        if("kevin".equals(username) && "q".equals(password)) {
        	final List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority("GUEST"));
            
            User user = new User();
            user.setUserId("kevin");
            user.setFirstName("Kevin");
            user.setLastName("Chua");
            
        	return new UsernamePasswordAuthenticationToken(new UserBean(username, password, grantedAuths, user), password, grantedAuths);
        } else {
        	return null;
        }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
