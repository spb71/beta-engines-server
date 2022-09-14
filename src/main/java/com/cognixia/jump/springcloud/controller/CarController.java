package com.cognixia.jump.springcloud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@CrossOrigin
	@GetMapping("/cars/{car_id}")
	public Cars getCar(@PathVariable long car_id) {
		Optional<Cars> carsOpt = service.findById(car_id);
		if (carsOpt.isPresent()) {
			return carsOpt.get();
		}
		return new Cars();
	}
	
	@CrossOrigin
	@PostMapping("/add/cars")
	public void addCar(@RequestBody Cars newCar) {
		newCar.setCar_id(-1L);
		Cars added = service.save(newCar);
		System.out.println("added a new car" + added);
	}
	
	@CrossOrigin
	@PutMapping("/update/cars")
	public @ResponseBody String updateCar(@RequestBody Cars updateCar) {
		Optional<Cars> found = service.findById(updateCar.getCar_id());
		if (found.isPresent()) {
			service.save(updateCar);
			return "saved " + updateCar.toString();
		}
		else return "Could not update car, maybe the id doesn't exist?";
	}
	@CrossOrigin
	@DeleteMapping("/delete/cars/{car_id}")
	public ResponseEntity<String> deleteCar(@PathVariable long car_id) {
		Optional<Cars> found = service.findById(car_id);
		if(found.isPresent()) {
			service.deleteById(car_id);
			return ResponseEntity.status(200).body("deleted the car");
		}
		else {
			return ResponseEntity.status(400).header("car id", car_id + "")
					.body("car id = " + car_id + " was not found");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}