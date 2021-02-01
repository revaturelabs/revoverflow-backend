package com.revature.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTOs.LoginFormDto;
import com.revature.repositories.UserRepository;
import com.revature.security.jwt.JwtSuccessHandler;
import com.revature.security.jwt.TokenSigner;

public class LoginFilter extends AbstractAuthenticationProcessingFilter{
	
	private final ObjectMapper mapper;
	private final AuthenticationProvider authenticationProvider;

	protected LoginFilter(ObjectMapper mapper, AuthenticationProvider authenticationProvider, TokenSigner tokenSigner, UserRepository userRepository) {
	    super(new AntPathRequestMatcher("/login", HttpMethod.POST.toString()));
	    this.mapper = mapper;
	    this.authenticationProvider = authenticationProvider;
	    this.setAuthenticationSuccessHandler(new JwtSuccessHandler(tokenSigner, userRepository, mapper));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
		LoginFormDto loginForm = mapper.readValue(req.getInputStream(), LoginFormDto.class);
	    return authenticationProvider.authenticate(new LoginFormToken(loginForm));
	}

}
