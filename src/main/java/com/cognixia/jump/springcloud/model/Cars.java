package com.cognixia.jump.springcloud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
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
	private Integer vehicle_year;
	
	@Column
	private String vin;
	
	@Column
	private Integer mileage;
	
	@Column
	private Double price;
	
	public Cars() {
		this.car_id = -1L;
		this.make = "N/A";
		this.model = "N/A";
		this.color = "N/A";
		this.trim_level = "N/A";
		this.vehicle_type = "N/A";
		this.vehicle_year = 0;
		this.vin = "N/A";
		this.mileage = 0;
		this.price = 0.0;
	}

	public Cars(Long car_id, String make, String model, String color, String trim_level, String vehicle_type,
			Integer vehicle_year, String vin, Integer mileage, Double price) {
		super();
		this.car_id = car_id;
		this.make = make;
		this.model = model;
		this.color = color;
		this.trim_level = trim_level;
		this.vehicle_type = vehicle_type;
		this.vehicle_year = vehicle_year;
		this.vin = vin;
		this.mileage = mileage;
		this.price = price;
	}

	public Long getCar_id() {
		return car_id;
	}

	public void setCar_id(Long car_id) {
		this.car_id = car_id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTrim_level() {
		return trim_level;
	}

	public void setTrim_level(String trim_level) {
		this.trim_level = trim_level;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	public Integer getVehicle_year() {
		return vehicle_year;
	}

	public void setVehicle_year(Integer vehicle_year) {
		this.vehicle_year = vehicle_year;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cars [car_id=" + car_id + ", make=" + make + ", model=" + model + ", color=" + color + ", trim_level="
				+ trim_level + ", vehicle_type=" + vehicle_type + ", vehicle_year=" + vehicle_year + ", vin=" + vin
				+ ", mileage=" + mileage + ", price=" + price + "]";
	}
}
