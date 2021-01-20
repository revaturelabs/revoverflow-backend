package com.revature.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.entities.User;
import com.revature.repositories.UserRepository;

public class JwtSuccessHandler implements AuthenticationSuccessHandler {

	  private final TokenSigner tokenSigner;
	  private final UserRepository userRepository;
	  private final ObjectMapper mapper;
	  private final Logger logger = LoggerFactory.getLogger(getClass());

	  public JwtSuccessHandler(TokenSigner tokenSigner, UserRepository userRepository, ObjectMapper mapper) {
	    this.tokenSigner = tokenSigner;
	    this.userRepository = userRepository;
	    this.mapper = mapper;
	  }

	  @Override
	  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	    final String token = tokenSigner.sign(authentication);
	    response.addHeader(HttpHeaders.AUTHORIZATION, token);
	    logger.info("Found authentication: {}", authentication);
	    final User user = userRepository.findByEmail(authentication.getName());
	    logger.info("Found client: {}", user);
	    response.getOutputStream().write(mapper.writeValueAsBytes(user));
	  }
}
