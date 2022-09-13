package com.cognixia.jump.springcloud.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cognixia.jump.springcloud.service.MyAccountDetails;
import com.cognixia.jump.springcloud.model.Accounts;
import com.cognixia.jump.springcloud.repository.AccountsRepository;

public class MyAccountDetailsService implements UserDetailsService {
	
	@Autowired
	AccountsRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Accounts> userFound = repo.findByUsername(username);
		
		
		if(userFound.isEmpty()) {
			throw new UsernameNotFoundException(username);
		}
		
		// as long as we found the user, create a user details object with all the relevant info for security 
		// security will take this object and perform authorization & authentication
		return new MyAccountDetails( userFound.get() );
	}
	}

	
	// method will by called by Spring Security when a request comes in
	// credentials (username + password) passed through the request will be loaded in
	// username will be passed to this method (as an argument), then will call the UserRepository in order to find a user with that username
	// As long as this user is found, User info will be passed to a UserDetails object and returned
		
	