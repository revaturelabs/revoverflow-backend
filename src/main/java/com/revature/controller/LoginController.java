package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.DTOs.RSSUserDTO;
import com.revature.entities.User;
import com.revature.services.RSSService;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	RSSService rssService;
	
	
	/** This method is used for logging in a user and validating their credentials with RSS account service
	 * 
	 * Params: userID: the user's id which we are getting the points for.
	 * @param email 	This is the user's email needed for login validation
	 * @param password 	User must supply a password for validation
	 * 
	 * @return User		This is the instance of the User entity in our database provided from the RSS account service	
	 * 	 */
	@PostMapping
	public User loginUser(@RequestBody RSSUserDTO u) {
		return rssService.login(u);
		
	}
	
}
