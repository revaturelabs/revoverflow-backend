package com.revature.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.revature.DTOs.LoginFormDto;

public class LoginFormToken extends UsernamePasswordAuthenticationToken {
	
	public LoginFormToken(LoginFormDto dto) {
		super(dto.getEmail(), dto.getPassword());
	}
}
