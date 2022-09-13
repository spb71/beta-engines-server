package com.cognixia.jump.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.springcloud.model.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Integer>{
	@Query("select a from accounts a where a.car_id = ?1")
	Accounts findAccountById(Integer Id);

}
