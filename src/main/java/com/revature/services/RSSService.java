package com.revature.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
		// create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    
		String uri = "http://ec2-34-203-75-254.compute-1.amazonaws.com:10001/user/login";
		String uri2 = "http://ec2-34-203-75-254.compute-1.amazonaws.com:10001/account/new";
		
		//create map for user login post parameters
		Map<String, Object> map = new HashMap<>();
		map.put("email", u.getEmail());
		map.put("password", u.getPassword());
		
		//build the request
		HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map,headers);
		
		//send Post Request
		ResponseEntity<RSSUserDTO> response= this.restTemplate.postForEntity(uri, entity, RSSUserDTO.class);
		
		//Begin building User object
		User user = new User();
		user.setEmail(u.getEmail());
		
		if(response.getStatusCode() == HttpStatus.OK) {	
			//continue building user from response body
			RSSUserDTO body = response.getBody();
			System.out.println(body);
			user.setAdmin(body.getAdmin());
			user.setFirstName(body.getFirstName());
			user.setLastName(body.getLastName());
			user.setProfilePicture(body.getProfilePic());
			user.setUserID(body.getUserId());
			
			//create map for new account post parameters
			map.clear();
			map.put("userId",body.getUserId());
			map.put("accTypeId",1);
			
			//build the request
			entity = new HttpEntity<>(map,headers);
			
			//send the request
			ResponseEntity<RSSAccountDTO> accResponse= this.restTemplate.postForEntity(uri2, entity, RSSAccountDTO.class);
			if(accResponse.getStatusCode()==HttpStatus.OK) {
				
				//finish building user object
				RSSAccountDTO accBody = accResponse.getBody();
				System.out.println(accBody);
				user.setRSSAccountId(accBody.getAccId());
				user.setPoints(accBody.getPoints());
				
			}
		}
		System.out.println(user);
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
