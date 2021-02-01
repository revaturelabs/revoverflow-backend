package com.revature.security.jwt;

import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JwtPresentToken extends AbstractAuthenticationToken {
	
	  private final String email;

	  public JwtPresentToken(String email, Collection<? extends GrantedAuthority> authorities) {
	    super(authorities);
	    this.email = email;
	  }

	  @Override
	  public Object getCredentials() {
	    return null;
	  }

	  @Override
	  public Object getPrincipal() {
	    return email;
	  }
	
}
