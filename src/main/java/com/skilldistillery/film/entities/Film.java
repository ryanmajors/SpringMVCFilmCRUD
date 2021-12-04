package com.skilldistillery.film.entities;

import java.util.List;

public class Film {
	
	private int id;
	
	private String title;
	
	private String description;
	
	private Integer releaseYear;
	
	private String languageId;

	private Integer rentalDuration;
	
	private double rentalRate;
	
	private Integer length;
	
	private double replacementCost;
	
	private String rating;
	
	private String features;
	
	private List<Actor> actors;
	

	public Film() {}

	public Film(int filmId, String title2, String desc, short releaseYear2, String lang, int rentDur, double rate,
			int length2, double repCost, String rating2, String features2) {
		
	}

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

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getLanguageId() {
		return languageId;
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Film id: " + id + "\nTitle: " + title + "\nDescription: " + description + "\nRating: " + rating + "\nReleaseYear: " + releaseYear
				+ "\nRentalRate: " + rentalRate + "\nLength: " + length + "\nReplacementCost: " + replacementCost;
	}


}
