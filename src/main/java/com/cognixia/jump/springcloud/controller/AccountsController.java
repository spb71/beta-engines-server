package com.cognixia.jump.springcloud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.springcloud.model.Accounts;
import com.cognixia.jump.springcloud.model.AuthenticationRequest;
import com.cognixia.jump.springcloud.model.AuthenticationResponse;
import com.cognixia.jump.springcloud.repository.AccountsRepository;
import com.cognixia.jump.springcloud.util.JwtUtil;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AccountsController {
	@Autowired
	AccountsRepository repo;
	
	//authentication manager -> validates/authenticates user credentials
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@GetMapping("/account")
	public ResponseEntity<List<Accounts>> getAllAccounts(){
		return ResponseEntity.ok().body(repo.findAll());
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<Accounts> getAccount(@PathVariable Integer id){
		Optional<Accounts> found = repo.findById(id);
		
		if(found.isEmpty()) {
			return null;
		}
		
		return ResponseEntity.ok().body(found.get());	
	}
	@PutMapping("/account/update")
	public ResponseEntity<?> updateAccount(@RequestBody Accounts acc){
		Integer userID = acc.getUser_id();
		Accounts acc0 = repo.findAccountById(userID);
		if(acc0.getBalance() !=null) {
			repo.save(acc);
			return ResponseEntity.ok().body("Record updated" + acc);
		}
		else {
			return ResponseEntity.status(401).body("Account Record not Found");
		}
	}
	@PostMapping("/account/create")
	public ResponseEntity<?> createAccount(@RequestBody Accounts acc){
		Integer userID = acc.getUser_id();
		Accounts acc0 = repo.findAccountById(userID);
//		if(acc0.getBalance() != null) {
//			return ResponseEntity.status(401).body("Account already exists");
//		}
//		else {
//			repo.save(acc);
//			return ResponseEntity.ok().body("Record created: "+acc);
//		}
		repo.save(acc);
		return ResponseEntity.ok().body("Record created: "  + acc);
	}
	@DeleteMapping("/account/delete/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable Integer Id){
		Accounts acc = repo.findAccountById(Id);
		if(acc != null) {
			repo.delete(acc);
			return ResponseEntity.ok().body("Record "+Id+" is deleted!");
		}else {
			return ResponseEntity.status(401).body("Record not found");
		}
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createJwtToken(@RequestBody AuthenticationRequest request) throws Exception {
		
		// try to catch the exception for bad credentials, just so we can set our own
		// message when this doesn't work
		try {
			// make sure we have a valid user by checking their username and password
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		} catch (BadCredentialsException e) {
			// provide our own message on why login didn't work
			throw new Exception("Incorrect username or password");
		}

		// as long as no exception was thrown, user is valid

		// load in the user details for that user
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

		// generate the token for that user
		final String jwt = jwtUtil.generateTokens(userDetails);

		// return the token
		return ResponseEntity.status(201).body( new AuthenticationResponse(jwt) );

	}
	
	
	
}
	


