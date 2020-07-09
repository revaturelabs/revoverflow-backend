package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.DTOs.RSSAccountDTO;
import com.revature.DTOs.RSSUserDTO;
import com.revature.entities.User;
import com.revature.services.RSSService;

@RestController
@RequestMapping("/RSS")
@CrossOrigin(origins = "*", 
methods = {RequestMethod.GET, RequestMethod.PUT, 
		RequestMethod.PATCH, RequestMethod.POST},
allowedHeaders = {"*"})//Remove cors methods when global cors is implemented
public class RSSController {

	@Autowired
	RSSService rssService;
	
	@PostMapping("/login")
	public User loginUser(@RequestBody RSSUserDTO u) {
		return rssService.login(u);
		
	}
	/* Gets the number of points for a user from the RSS account service database and updates the user's RSS points in our database
	 * 
	 * Params: userID: the user's id which we are getting the points for.
	 * 
	 * Returns: Number of points as an integer
	 */
	
	@GetMapping("/points/{id}")
	public int getPoints(@RequestParam int id) {
		return rssService.getPoints(id);
	}
	
	/* Adds points to a user's RSS account on the RSS account service database
	 * 
	 * Body params: userId:The user's Id which the points are being added to 
	 * 		 		points: the number of points to be added to the user
	 * 
	 * Returns: 	User entity with updated points
	 * */
	@PostMapping("/add")
	public User addPoints(@RequestBody RSSAccountDTO acc) {
		return rssService.addPoints(acc);
		
	}

}
