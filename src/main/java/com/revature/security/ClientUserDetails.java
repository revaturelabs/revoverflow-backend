package com.revature.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.revature.entities.User;

public class ClientUserDetails implements UserDetails{

	private final User user;
	
	public ClientUserDetails(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (user.isAdmin()) {
			return Collections.singleton(RevOverflowRole.ROLE_ADMIN);
		} else {
			return Collections.singleton(RevOverflowRole.ROLE_USER);
		}
	}

	@Override
	public String getPassword() {
	    return user.getPassword();
	}

	@Override
	public String getUsername() {
	    return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
	    return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	    return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
	    return true;
	}

	@Override
	public boolean isEnabled() {
	    return true;
	}
}
