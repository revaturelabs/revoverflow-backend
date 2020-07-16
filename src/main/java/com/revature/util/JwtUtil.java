package com.revature.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.revature.entities.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil implements Serializable {
	
	private String secret = "haishdoijocewpok";

	
	public String generateToken(User user) {
		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, user.getEmail());
	}
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 5 * 60 * 60 * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
