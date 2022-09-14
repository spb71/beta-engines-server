package com.cognixia.jump.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cognixia.jump.springcloud.filter.JwtRequestFilter;


@Configuration
public class SecurityConfiguration {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	// Authentication - who are you?
	@Bean
	protected UserDetailsService userDetailsService() {
			
		return userDetailsService;
	}
	
	// Authorization - what do you want?
	@Bean
	protected SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
		
		http.csrf().disable()
			.authorizeRequests() 
			.anyRequest().permitAll()
			.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		//this request will go through many filters, make sure that the FIRST filter that is checked is 
		//the filter for jwts, in order to make sure of that, the filter has to be checked before you check the
		// username & password (filter)
		//http.addFilterAt(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
				
		return http.build();
	}
	
	
	// Encoder -> method that will encode/decode all the user passwords
	@Bean
	protected PasswordEncoder encoder() {
		
		return  NoOpPasswordEncoder.getInstance();
		//new BCryptPasswordEncoder();
	}
	
	// load the encoder & user details service that are needed for spring security to do authentication
	@Bean
	protected DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder( encoder() );
		
		return authProvider;
	}
	
	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
		return authConfig.getAuthenticationManager();
	}
	
}