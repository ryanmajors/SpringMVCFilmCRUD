package com.skilldistillery.film.entities;

import java.time.LocalDateTime;

public class Customer {

	private int id;

	private String firstName;

	private String lastName;

	private String email;

	private LocalDateTime createDate;

	Customer() {
	}

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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Customer id: " + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nEmail: " + email
				+ "\nCreated Date: " + createDate;
	}

}
