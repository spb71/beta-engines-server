package com.cognixia.jump.springcloud.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognixia.jump.springcloud.model.Accounts;

public class MyAccountDetailsService implements UserDetails {

	

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private boolean enabled;
	private List<GrantedAuthority> authorities;
	
	
	// when a new object created, will extract only the RELEVANT info from our User object
	public MyUserDetails(Accounts account) {
		
		this.username = account.getUsername();
		this.password = account.getPassword();
		this.enabled = account.isEnabled();
		
		// Granted Authority -> permissions/grants a user has access to retrieve or operations to perform
		// GA is given based on the user's roles
		this.authorities = Arrays.asList( new SimpleGrantedAuthority( account.getRole().name() ) );
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
