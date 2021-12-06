package com.skilldistillery.film.entities;

public class FilmCategory {
	
	private int filmId;
	
	private int categoryId;

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "filmCategory [filmId=" + filmId + ", categoryId=" + categoryId + "]";
	}
	
	

}
