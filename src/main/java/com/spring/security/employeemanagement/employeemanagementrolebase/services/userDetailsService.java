package com.spring.security.employeemanagement.employeemanagementrolebase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.employeemanagement.employeemanagementrolebase.model.User;
import com.spring.security.employeemanagement.employeemanagementrolebase.repository.UserRepository;




@Service
public class userDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepository  userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  userRepository.findByusername(username);
		
		if(user == null) {
			
			throw new UsernameNotFoundException("User not Found");
		}
		
		return new CustomUserDetails(user) ;
	}

}
