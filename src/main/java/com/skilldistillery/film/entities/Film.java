package com.skilldistillery.film.entities;


public class Film {
	
	private int id;
	
	private String title;
	
	private String description;
	
	private Integer releaseYear;
	
	private double rentalRate;
	
	private Integer length;
	
	private double replacementCost;
	
	private Rating rating;
	
	Film() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Film id: " + id + "\nTitle: " + title + "\nDescription: " + description + "\nRating: " + rating + "\nReleaseYear: " + releaseYear
				+ "\nRentalRate: " + rentalRate + "\nLength: " + length + "\nReplacementCost: " + replacementCost;
	}
	
	
}
