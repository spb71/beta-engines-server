package com.cognixia.jump.springcloud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Accounts implements Serializable{
	private static final long serialVersionUID = 1l;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column
	private Double balance;
	
	@Column( columnDefinition = "boolean default true" )
	private boolean enabled;
	
	public Accounts() {
		this.user_id = -1;
		this.username = "N/A";
		this.password = "N/A";
		this.name = "N/A";
		this.balance = 0.0;
	}

	public Accounts(Integer user_id, String username, String password, String name, Double balance) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.balance = balance;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Accounts [user_id=" + user_id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", balance=" + balance + "]";
	}
	
	
	
	
	
}
