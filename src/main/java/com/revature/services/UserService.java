package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	/** @Author James Walls */
	public User findById(int userID) {
		return userRepository.findById(userID)
					.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

}
