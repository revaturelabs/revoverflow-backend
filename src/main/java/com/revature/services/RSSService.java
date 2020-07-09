package com.revature.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.DTOs.RSSAccountDTO;
import com.revature.DTOs.RSSUserDTO;
import com.revature.entities.User;

@Service
public class RSSService {
	/*
	 * Add Points - Kei
	 * 
	 * Update Points - Haji
	 * 
	 * Login - Ryan
	*/
	
	
	private RestTemplate restTemplate;
	
	public RSSService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	
	public User login(RSSUserDTO u) {
		// TODO Auto-generated method stub
		//System.out.println(restTemplate.postForEntity("http://ec2-34-203-75-254.compute-1.amazonaws.com:10001/" ,u, UserDTO.class));
		return null;
	}

	
	public int getPoints(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public User addPoints(RSSAccountDTO acc) {
		// TODO Auto-generated method stub
		return null;
	}


}
