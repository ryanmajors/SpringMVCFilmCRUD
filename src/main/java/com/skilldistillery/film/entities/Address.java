package com.skilldistillery.film.entities;


public class Address {

	private int id;
	
	private String street;
	
	private String street2;
	
	private String state;
	
	private String city;
	
	private String postalCode;
	
	private String phone;

	Address() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Address id: " + id + "\nStreet: " + street + "\nStreet2: " + street2 + "\nState: " + state + "\nCity: "
				+ city + "\nPostalCode: " + postalCode + "\nPhone:" + phone;
	}

}
