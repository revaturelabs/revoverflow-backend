package com.revature.security.jwt;

import org.springframework.security.core.Authentication;

public interface TokenParser {

	Authentication parse(String token);
}
