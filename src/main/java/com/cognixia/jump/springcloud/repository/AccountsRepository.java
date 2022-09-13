package com.cognixia.jump.springcloud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cognixia.jump.springcloud.model.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer>{
	
	
	// custom query for finding user by username
    // will be used to load in user and check credentials when sending requests to the API
    // Optional -> we don't know if a user with this username exists
    public Optional<Accounts> findByUsername(String username);

}
