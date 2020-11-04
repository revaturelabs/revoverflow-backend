package com.revature.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Users;
import com.revature.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getById(@PathVariable int id){
		Optional<Users> user = userRepository.findById(id);
		
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());			
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Users>> getAllUser(){
		List<Users> users = userRepository.findAll();
		
		if(users.size() != 0) {
			System.out.print(users.size());
			return ResponseEntity.ok(users);		
		}
		
		return ResponseEntity.noContent().build();
	}
}
