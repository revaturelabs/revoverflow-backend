package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.DTOs.UserDTO;
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
	public User loginUser(@RequestBody UserDTO u) {
		return null;
		
	}
	
	@GetMapping("/points")
	public void getPoints() {
	}
	
	@PostMapping("/add")
	public void addPoints() {
		
	}

}
