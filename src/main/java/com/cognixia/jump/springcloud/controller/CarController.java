package com.cognixia.jump.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.springcloud.model.Cars;
import com.cognixia.jump.springcloud.repository.CarRepository;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class CarController {
	@Autowired
	CarRepository service;
	
	@CrossOrigin
	@GetMapping("/cars")
	public List<Cars> getAllCars() {
		return service.findAll();
	}
}