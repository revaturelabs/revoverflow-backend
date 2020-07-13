package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RSSService rssService;
	
	/*
	 * @Author Ryan Clayton
	 */

	public User getUserById(int id) {
		Optional<User> optUser = userRepository.findById(id);
		System.out.println("hello");
		if(optUser.isPresent()) {
			User user = optUser.get();
			try {
				
				user.setPoints(rssService.getPoints(id));
			}catch(Exception e){
				System.out.println(e.getLocalizedMessage());
			}
			return userRepository.save(user);
		}
		else {
			return null;
		}
	}

}
