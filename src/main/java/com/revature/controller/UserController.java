package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.entities.User;
import com.revature.services.UserService;

@RequestMapping("/users")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	/** @Author James Walls */
	@GetMapping("/{userID}")
	public User getUserInformationById(@PathVariable int userID) {
		return userService.findById(userID);
	}

}
