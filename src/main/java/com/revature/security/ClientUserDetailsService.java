package com.revature.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.entities.User;
import com.revature.repositories.UserRepository;

@Service
public class ClientUserDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	public ClientUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username);
		return new ClientUserDetails(user);
	}
}
