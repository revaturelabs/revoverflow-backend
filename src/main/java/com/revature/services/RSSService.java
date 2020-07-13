package com.revature.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.revature.repositories.UserRepository;
import com.revature.util.JwtUtil;

@Service
public class RSSService {
	/*
	 * Add Points - Kei
	 * 
	 * Update Points - Haji
	 * 
	 * Login - Ryan
	*/
	
	@Autowired
	UserRepository userRepository;
	
	private RestTemplate restTemplate;
	
	public RSSService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	/*
	 * @Author Ryan Clayton
	 */
	public User login(RSSUserDTO u) {
		// create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    
		String uri = "http://ec2-34-203-75-254.compute-1.amazonaws.com:10001/user/login";
		
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
		
		if(response.hasBody()) {	
			//continue building user from response body
			RSSUserDTO body = response.getBody();
			
			
			if(!userRepository.existsById(body.getUserId())) {
				user.setAdmin(body.getAdmin());
				user.setFirstName(body.getFirstName());
				user.setLastName(body.getLastName());
				user.setProfilePicture(body.getProfilePic());
				user.setUserID(body.getUserId());
				
				
				
				String uri2 = "http://ec2-34-203-75-254.compute-1.amazonaws.com:10001/account/new";
				//create map for new account post parameters
				map.clear();
				map.put("userId",body.getUserId());
				map.put("accTypeId",3);
				
				//build the request
				entity = new HttpEntity<>(map,headers);
				//send the request
				ResponseEntity<RSSAccountDTO> accResponse= this.restTemplate.postForEntity(uri2, entity, RSSAccountDTO.class);
				if(accResponse.hasBody()) {
				
					//finish building user object
					RSSAccountDTO accBody = accResponse.getBody();
					user.setRSSAccountId(accBody.getAccId());
					user.setPoints(accBody.getPoints());
				
				}
				//create jwt for user
				JwtUtil jwt = new JwtUtil();
				user.setJwt(jwt.generateToken(user));
				
			}else {
				Optional<User> optUser = userRepository.findById(body.getUserId());
				if (optUser.isPresent()) {
					//get user data from our database
					user = optUser.get();
					
					//create url for rss points request
					String uri2 = "http://ec2-34-203-75-254.compute-1.amazonaws.com:10001/account/account";
					//create map for new account post parameters
					map.clear();
					map.put("userId",user.getUserID());
					map.put("accId",user.getRSSAccountId());
					
					//build the request
					entity = new HttpEntity<>(map,headers);
				
					//send the request
					ResponseEntity<RSSAccountDTO> accResponse= this.restTemplate.postForEntity(uri2, entity, RSSAccountDTO.class);
					if(accResponse.hasBody()) {
						user.setPoints(accResponse.getBody().getPoints());
					}
					//create jwt token for our user
					JwtUtil jwt = new JwtUtil();
					user.setJwt(jwt.generateToken(user));

				}
			}
			
			return userRepository.save(user);
		}		
		else {
			return null;
		}
	}

	/*
	 * @Author
	 */
	public int getPoints(int id) {
		// TODO Auto-generated method stub
		return 0;
	}


	/*
	*@Author Haji
	*/

	public RSSAccountDTO addPoints(RSSAccountDTO acc) {
		String uri =  "http://ec2-34-203-75-254.compute-1.amazonaws.com:10001/account/account";
		 	HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		    
		    Map<String, Object> map = new HashMap<>();
			map.put("accId", acc.getAccId());

			HttpEntity<Map<String,Object>> entity = new HttpEntity<>(map,headers);
			
			ResponseEntity<RSSAccountDTO> response= this.restTemplate.postForEntity(uri, entity, RSSAccountDTO.class);
	       
	        RSSAccountDTO account = response.getBody();
	        System.out.println(account);
	        account.setPoints(account.getPoints() + 20);
	        System.out.println(account);
	        return account;

	}


}
