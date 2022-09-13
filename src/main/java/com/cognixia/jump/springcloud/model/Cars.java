package com.cognixia.jump.springcloud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cars implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long car_id;
	
	@Column
	private String make;
	
	@Column
	private String model;
	
	@Column
	private String color;
	
	@Column
	private String trim_level;
	
	@Column
	private String vehicle_type;
	
	@Column
	private String vehicle_year;
	
	@Column
	private String vin;
	
	@Column
	private Integer mileage;
	
	@Column
	private Double price;
}
