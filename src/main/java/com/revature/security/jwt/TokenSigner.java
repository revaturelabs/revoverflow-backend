package com.revature.security.jwt;

import org.springframework.security.core.Authentication;

public interface TokenSigner {

	String sign(Authentication authentication);
}
