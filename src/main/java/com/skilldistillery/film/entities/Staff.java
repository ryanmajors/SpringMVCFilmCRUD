package com.skilldistillery.film.entities;


public class Staff {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;

	Staff() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Staff id: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " + email;
	}

}
