package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

	Actor findActorById(int actorId);

	List<Actor> findActorsByFilmId(int filmId);

	List<Film> findFilmByFilmWordSearch(String searchWord);

	List<Actor> findActorsByFilmWordSearch(String searchWord);

	Film addNewFilm(Film newFilm);

	Film deleteFilm(Film dFilm);

	Film updateFilm(Film uFilm);

	Film findFilmById(int filmId);

	public Category findCategoryByFilmId(int filmId);

	public Category findCategoryById(int categoryId);

	public Category linkFilmandCategory(int filmId, int categoryId);

	public String findLanguageName(int languageId);
}
