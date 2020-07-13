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
	
	@PostMapping
	public User loginUser(@RequestBody RSSUserDTO u) {
		return rssService.login(u);
		
	}
	/* Gets the number of points for a user from the RSS account service database and updates the user's RSS points in our database
	 * 
	 * Params: userID: the user's id which we are getting the points for.
	 * 
	 * Returns: Number of points as an integer
	 */
}
