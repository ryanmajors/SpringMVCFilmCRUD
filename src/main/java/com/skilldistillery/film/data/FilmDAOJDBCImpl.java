package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Category;
import com.skilldistillery.film.entities.Film;

@Service
public class FilmDAOJDBCImpl implements FilmDAO {

	private static final String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String user = "student";
	private static final String pass = "student";

	@Override
	public Film findFilmById(int filmId) {

		Film film = null;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, language.name, film.rental_duration, "
				+ "film.rental_rate, film.length, film.replacement_cost, film.rating  " + "FROM film "
				+ "JOIN language ON film.language_id = language.id " + "WHERE film.id = ?;";
		PreparedStatement preSt = null;

		try {
			preSt = conn.prepareStatement(sql);

			preSt.setInt(1, filmId);
			ResultSet actorResult = preSt.executeQuery();
			if (actorResult.next()) {
				film = new Film(); // Create the object
				// Here is our mapping of query columns to our object fields:
				film.setId(actorResult.getInt("film.id"));
				film.setTitle(actorResult.getString("film.title"));
				film.setDescription(actorResult.getString("film.description"));
				film.setReleaseYear(actorResult.getInt("film.release_year"));
				film.setLanguageId(actorResult.getInt("film.language_id"));
				film.setLanguageName(actorResult.getString("language.name"));
				film.setRentalDuration(actorResult.getInt("film.rental_duration"));
				film.setRentalRate(actorResult.getDouble("film.rental_rate"));
				film.setLength(actorResult.getInt("film.length"));
				film.setReplacementCost(actorResult.getDouble("film.replacement_cost"));
				film.setRating(actorResult.getString("film.rating"));
				film.setCategory(findCategoryByFilmId(filmId));
				System.err.println("Is this null= " + film.getCategory());
//				film.setFeatures(actorResult.getString("film.special_features"));
				film.setActors(findActorsByFilmId(filmId));

			}
			actorResult.close();
			preSt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		// List<Film> films = null;
		Actor actor = null;

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?;";
			PreparedStatement preSt = null;
			preSt = conn.prepareStatement(sql);
			preSt.setInt(1, actorId);

			ResultSet actorResult = preSt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor(); // Create the object
				// Here is our mapping of query columns to our object fields:
				actor.setId(actorResult.getInt("id"));
				actor.setFirstName(actorResult.getString("first_name"));
				actor.setLastName(actorResult.getString("last_name"));

				// An Actor has Films
			}
			actorResult.close();
			preSt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ...
		return actor;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor "
					+ "JOIN film_actor ON film_actor.actor_id = actor.id  "
					+ "JOIN film ON film.id = film_actor.film_id  " + "WHERE film.id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, filmId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				Actor actor = new Actor();
				// Create the object
				// Here is our mapping of query columns to our object fields:
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actors.add(actor);

			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, language.name, film.rental_duration, ";
			sql += " film.rental_rate, film.length, film.replacement_cost, film.rating"
					+ " FROM film JOIN film_actor ON film.id = film_actor.film_id "
					+ " JOIN language ON film.language_id = language.id" + " WHERE actor_id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, actorId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				film = new Film();

				film.setId(rs.getInt("film.id"));
				film.setTitle(rs.getString("film.title"));
				film.setDescription(rs.getString("film.description"));
				film.setReleaseYear(rs.getInt("film.release_year"));
				film.setLanguageId(rs.getInt("film.language_id"));
				film.setLanguageId(rs.getInt("language.name"));
				film.setRentalDuration(rs.getInt("film.rental_duration"));
				film.setRentalRate(rs.getDouble("film.rental_rate"));
				film.setLength(rs.getInt("film.length"));
				film.setReplacementCost(rs.getDouble("film.replacement_cost"));
				film.setRating(rs.getString("film.rating"));
//				film.setFeatures(rs.getString("film.special_features"));
				films.add(film);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Film> findFilmByFilmWordSearch(String searchWord) {
		List<Film> films = new ArrayList<>();
		Film film = null;

		try {
			String searchQuery = "%" + searchWord + "%";
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT film.id, film.title, film.description, film.release_year, film.language_id, language.name, film.rental_duration, "
					+ " film.rental_rate, film.length, film.replacement_cost, film.rating " + " FROM film "
					+ "JOIN language ON film.language_id = language.id" + " WHERE description LIKE ? OR title LIKE  ? ";
			PreparedStatement prestmt = conn.prepareStatement(sql);
			prestmt.setNString(1, searchQuery);
			prestmt.setNString(2, searchQuery);
			ResultSet rs = prestmt.executeQuery();
			while (rs.next()) {
				film = new Film();

				film.setId(rs.getInt("film.id"));
				film.setTitle(rs.getString("film.title"));
				film.setDescription(rs.getString("film.description"));
				film.setReleaseYear(rs.getInt("film.release_year"));
				film.setLanguageId(rs.getInt("film.language_id"));
				film.setLanguageName(rs.getString("language.name"));
				film.setRentalDuration(rs.getInt("film.rental_duration"));
				film.setRentalRate(rs.getDouble("film.rental_rate"));
				film.setLength(rs.getInt("film.length"));
				film.setReplacementCost(rs.getDouble("film.replacement_cost"));
				film.setRating(rs.getString("film.rating"));
				film.setCategory(findCategoryByFilmId(film.getId()));
//				film.setFeatures(rs.getString("film.special_features"));
				film.setActors(findActorsByFilmId(film.getId()));
				films.add(film);

			}
			rs.close();
			prestmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	@Override
	public List<Actor> findActorsByFilmWordSearch(String searchWord) {
		List<Actor> actors = new ArrayList<>();

		try {
			String searchQuery = "%" + searchWord + "%";
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor "
					+ "JOIN film_actor ON film_actor.actor_id = actor.id  "
					+ "JOIN film ON film.id = film_actor.film_id "
					+ " WHERE film.description LIKE ? OR film.title LIKE  ? ;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, searchQuery);
			pstmt.setNString(2, searchQuery);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor();
				// Create the object
				// Here is our mapping of query columns to our object fields:
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actors.add(actor);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	public String toString(String limited) {

		return limited;
	}

	public String toString() {

		return null;

	}

	@Override
	public Film addNewFilm(Film newFilm) {

		String sql = " INSERT INTO film (title, description, release_year, language_id , rental_duration, rental_rate, length, replacement_cost, rating ) VALUES(?,?,?,?,?,?,?,?,?)";
		String sql2 = " INSERT INTO film_category SET film_id=?, catagory_id=?";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, newFilm.getTitle());
			st.setString(2, newFilm.getDescription());
			st.setInt(3, newFilm.getReleaseYear());
			st.setInt(4, newFilm.getLanguageId());
			st.setInt(5, newFilm.getRentalDuration());
			st.setDouble(6, newFilm.getRentalRate());
			st.setInt(7, newFilm.getLength());
			st.setDouble(8, newFilm.getReplacementCost());
			st.setString(9, newFilm.getRating());
//			st.setString(10, newFilm.getFeatures());
			System.out.println(st);
			int uc = st.executeUpdate();
			ResultSet keys = st.getGeneratedKeys();
			if (uc == 1) {
				if (keys.next()) {
					newFilm.setId(keys.getInt(1));
					System.out.println("Film title " + newFilm.getTitle() + " added to list ");
				} else {
					System.err.println("uc was 1, rest of code failed... key no key");
				}
			} else {
				System.err.println("Error, error you or I may have done something wrong.");
				conn.rollback();
				newFilm = null;
				conn.close();
				return newFilm;
			}

			// If we made it this far, no exception occurred.
			conn.commit(); // Commit the transaction
			st.close();
			keys.close();

		} catch (SQLException e) {
			// Something went wrong.
			System.err.println("Error during inserts.");
			e.printStackTrace();
			// Need to rollback, which also throws SQLException.
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFilm;
	}

	@Override
	public Film deleteFilm(Film film) {

		String sql = "DELETE FROM film WHERE id = ?";
		String sql2 = "DELETE FROM film_category where film_id=?";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, film.getId());
			pstmt.executeUpdate();
			conn.commit();
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, film.getId());

			System.out.println(st);
			int uc = st.executeUpdate();
			if (uc == 1) {

				System.out.println("Film title " + film.getTitle() + " Deleted from list ");
			} else {
				System.err.println("Error, error you or I may have done something wrong.");
				conn.rollback();
				film = null;
				conn.close();
				return film;
			}

			// If we made it this far, no exception occurred.
			conn.commit(); // Commit the transaction
		} catch (SQLException e) {
			// Something went wrong.
			System.err.println("Error during inserts.");
			e.printStackTrace();
			// Need to rollback, which also throws SQLException.
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public Film updateFilm(Film film) {
		String sql = " UPDATE film SET title=?, description=?, release_year=?, language_id=?, rental_duration=?, rental_rate=?, length=?, replacement_cost=?, rating=?  WHERE id = ?";
//		String sql2 = " UPDATE film_category SET category_id =? WHERE category_film.film_id =? ";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // Start transaction
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, film.getTitle());
			st.setString(2, film.getDescription());
			st.setInt(3, film.getReleaseYear());
			st.setInt(4, film.getLanguageId());
			st.setInt(5, film.getRentalDuration());
			st.setDouble(6, film.getRentalRate());
			st.setInt(7, film.getLength());
			st.setDouble(8, film.getReplacementCost());
			st.setString(9, film.getRating());
			st.setInt(10, film.getId());

//			PreparedStatement st2 = conn.prepareStatement(sql);
//			st2.setInt(1, film.getCategory().getId());
//			st2.setInt(2, film.getId());
//			st2.executeUpdate();
			System.out.println(st);
			int uc = st.executeUpdate();
			if (uc == 1) {

				System.out.println("Film title " + film.getTitle() + " updated from list ");
			} else {
				System.err.println("Error, error you or I may have done something wrong.");
				conn.rollback();
				film = null;
				conn.close();
				return film;
			}
			// String sql2 = "UPDATE //Working on this spot do no touch

			// If we made it this far, no exception occurred.
			conn.commit(); // Commit the transaction
		} catch (SQLException e) {
			// Something went wrong.
			System.err.println("Error during inserts.");
			e.printStackTrace();
			// Need to rollback, which also throws SQLException.
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					System.err.println("Error rolling back.");
					e1.printStackTrace();
				}
			}
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}

	public Category findCategoryByFilmId(int filmId) {
		Category category = new Category();
		System.err.println("inside findCategoryByFilmId " + filmId);
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT category.id, category.name FROM category LEFT JOIN film_category ON category.id = film_category.category_id LEFT JOIN film ON film.id = film_category.film_id WHERE film.id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, filmId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {// Create the object
				// Here is our mapping of query columns to our object fields:
				category.setId(rs.getInt("category.id"));
				category.setName(rs.getString("category.name"));
				System.err.println(category);
				rs.close();
				pstmt.close();
				conn.close();
			} else {
				conn.rollback();
				category.setId(filmId);
				category.setName("Action");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}

		return category;
	}

	public Category findCategoryById(int categoryId) {
		Category category = new Category();
		System.err.println("inside findCategoryById " + categoryId);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT id, name FROM category WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, categoryId);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				// Create the object
				// Here is our mapping of query columns to our object fields:
				category.setId(rs.getInt("category.id"));
				category.setName(rs.getString("category.name"));

				rs.close();
				pstmt.close();
				conn.close();
			} else {
				conn.rollback();
				rs.close();
				pstmt.close();
				conn.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;

	}

	public Category linkFilmandCategory(int filmId, int categoryId) {
		Category category = new Category();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false); // Start transaction
			String sql = "INSERT INTO film_category SET film_id=?, category_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, filmId);
			pstmt.setInt(2, categoryId);

			int rs = pstmt.executeUpdate();
			if (rs == 1) {
				category = findCategoryById(categoryId);
				conn.commit();
				pstmt.close();
				conn.close();
				return category; // 1 is success

			} else {
				System.err.println("Error, error you or I may have done something wrong.");
				conn.rollback();
				pstmt.close();
				conn.close();
				return category; // zero is failed

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category; // failed bc it didnt make it in to anything,...

	}

	public String findLanguageName(int languageId) {
		String languageName = null;
		;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT name FROM language WHERE id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, languageId);
			ResultSet rs = pstmt.executeQuery();
			languageName = rs.getString("name");
			System.err.println(languageName);
			pstmt.close();
			conn.close();
			return languageName; // 1 is success

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return languageName; // failed bc it didnt make it in to anything,...

	}
}
