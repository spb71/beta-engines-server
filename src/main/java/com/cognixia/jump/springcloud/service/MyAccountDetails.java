package com.cognixia.jump.springcloud.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognixia.jump.springcloud.model.Accounts;



public class MyAccountDetails implements UserDetails{

	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> authorities;
	
	public MyAccountDetails(Accounts account) {
		
		this.username = account.getUsername();
		this.password = account.getPassword();
		this.enabled = account.isEnabled();
		
		// Granted Authority -> permissions/grants a user has access to retrieve or operations to perform
		// GA is given based on the user's roles
		//Do not need  right now ? maybe ask toju about it
		//this.authorities = Arrays.asList( new SimpleGrantedAuthority( Accounts.getRole().name() ) );
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	
	// all methods after here:
	// - DON'T NEED to store this type of info in the user table
	// - store this info if worthwhile for your security 
	// - have all these methods return true manually if not storing the info
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}



	public UserDetails loadUserByUsername(String username2) {
		// TODO Auto-generated method stub
		return null;
	}


}