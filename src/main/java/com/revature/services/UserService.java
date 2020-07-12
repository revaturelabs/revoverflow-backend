package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	/*
	 * @Author Ryan Clayton
	 */
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

}
