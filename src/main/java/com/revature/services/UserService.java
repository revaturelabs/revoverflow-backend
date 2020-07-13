package com.revature.services;

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
	
	/**
	 * @author Ryan Clayton
	 * @param id this is the user's Id
	 * @return User this returns the user entity with updated RSS points
	 */

	public User getUserById(int id) {
		Optional<User> optUser = userRepository.findById(id);
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
