package com.cognixia.jump.springcloud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.springcloud.model.Accounts;
import com.cognixia.jump.springcloud.repository.AccountsRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AccountsController {
	@Autowired
	AccountsRepository repo;
	
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
	@PostMapping("/account/update")
	public ResponseEntity<?> updateAccount(@RequestBody Accounts acc){
		if(acc.getUser_id()!=null) {
			repo.save(acc);
			return ResponseEntity.ok().body("Record updated" + acc);
		}
		else {
			return ResponseEntity.status(401).body("Account Record not Found");
		}
	}
}
	


