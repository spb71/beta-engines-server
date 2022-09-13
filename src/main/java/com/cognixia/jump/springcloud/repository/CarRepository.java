package com.cognixia.jump.springcloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.springcloud.model.Cars;
@Repository
public interface CarRepository extends JpaRepository<Cars, Long> {
	List<Cars> findAll();
}