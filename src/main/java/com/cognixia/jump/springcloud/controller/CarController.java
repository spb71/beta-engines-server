package com.cognixia.jump.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.springcloud.repository.CarRepository;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class CarController {
	@Autowired
	CarRepository service;
}