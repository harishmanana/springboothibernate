package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "UserAddress")
public class UserAddress {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int addressId;
	
	@Column
	private String location;
	
	@Column
	private String city;
	
	public UserAddress() {
		
	}

	public UserAddress(String location, String city) {
		this.location = location;
		this.city = city;
	}
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
		return "Location = " + getLocation() + "\tCity = " + getCity();
	}
}
