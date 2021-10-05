package com.learn.spring.SpringHelloWorld.bean;

public class Address {
	private String addressLine1, city, state, country;

	
	public Address() {
		
	}
	
	public Address(String addressLine1, String city, String state, String country) {
		this.addressLine1 = addressLine1;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		System.out.println("Setting AddressLine 1");
		this.addressLine1 = addressLine1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String toString() {
		return addressLine1 + " " + city + " " + state + " " + country;
	}
}
