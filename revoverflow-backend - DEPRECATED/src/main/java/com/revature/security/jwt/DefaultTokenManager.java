package com.revature.security.jwt;

import java.security.Key;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class DefaultTokenManager extends AbstractTokenManager{

	public DefaultTokenManager() {
	    super();
	  }

	  public DefaultTokenManager(Key signingKey, SignatureAlgorithm signatureAlgorithm) {
	    super(signingKey, signatureAlgorithm);
	  }
}
