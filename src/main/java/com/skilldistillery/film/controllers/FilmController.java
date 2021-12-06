package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;

	@RequestMapping({ "/", "home.do" })
	public String home(Model model) {
		model.addAttribute("TEST", "Hello, Spring MVC!");
		return "home";
	}

	@RequestMapping("addfilm")
	public String addFilm(Model model) {
		model.addAttribute("TEST", "Hello, Spring MVC!");
		return "addfilm";
	}

	@RequestMapping("editfilmerror")
	public String editFilmError(Model model) {
		model.addAttribute("TEST", "Hello, Spring MVC!");
		return "editfilmerror";
	}

	@RequestMapping("deletefilmerror")
	public String deleteFilmError(Model model) {
		model.addAttribute("TEST", "Hello, Spring MVC!");
		return "deletefilmerror";
	}
	@RequestMapping("search")
	public String accessSearchPage() {
		return "search";
	}

	@RequestMapping(path = "getfilmbyid.do", params = "filmid", method = RequestMethod.GET)
	public ModelAndView getFilmById(int filmid) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.findFilmById(filmid);
		mv.addObject("film", film);
		mv.setViewName("result");
		return mv;
	}

	@RequestMapping(path = "getfilmbykeyword.do", params = "filmphrase", method = RequestMethod.GET)
	public ModelAndView getFilmsByFilmPhrase(String filmphrase) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.findFilmByFilmWordSearch(filmphrase);
		mv.addObject("films", films);
		mv.setViewName("result");
		return mv;
	}

	@RequestMapping(path = "addnewfilm.do", method = RequestMethod.GET)
	public ModelAndView addNewFilmToDB(String title, String description, int releaseyear, int languageid,
			int rentalduration, String rentalrate, int length, String replacementcost, String rating, int categoryid) {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		try {
			film.setTitle(title);
			film.setDescription(description);
			film.setReleaseYear(releaseyear);
			film.setLanguageId(languageid);
			film.setLanguageName(filmDAO.findLanguageName(languageid));
			film.setRentalDuration(rentalduration);
			film.setRentalRate(Double.parseDouble(rentalrate));
			film.setLength(length);
			film.setReplacementCost(Double.parseDouble(replacementcost));
			film.setRating(rating);
			film.setCategory(filmDAO.findCategoryById(categoryid));
		} catch (NumberFormatException e) {
			System.err.println("Potential invalid fields. Try again");
			mv.setViewName("editfilmerror");
			return mv;
		} catch (NullPointerException e) {
			System.err.println("Potential invalid fields. Try again");
			mv.setViewName("editfilmerror");
			return mv;
		}
//		film.setFeatures(features);

		film = filmDAO.addNewFilm(film);
		film.setCategory(filmDAO.linkFilmandCategory(film.getId(), categoryid));
		mv.addObject("film", film);
		mv.setViewName("result");
		return mv;
	}

	@RequestMapping(path = "deletefilm.do")
	public ModelAndView deleteFilmFromDB(int deletefilmid) {
		Film film = filmDAO.findFilmById(deletefilmid);
		ModelAndView mv = new ModelAndView();
		filmDAO.deleteFilm(film);
		if (filmDAO.findFilmById(film.getId()) == null) {
			mv.setViewName("deleteconfirmation");
			return mv;
		} else {
			mv.setViewName("");
		}
		mv.setViewName("deletefilmerror");
		return mv;
	}

	@RequestMapping("editfilm")
	public ModelAndView editFilm(int editfilmid) {
		Film film = filmDAO.findFilmById(editfilmid);
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", film);
		mv.setViewName("editfilm");

		return mv;

	}

	@RequestMapping("editfilm.do")
	public ModelAndView submitEditedFilm(int id, String title, String description, int releaseyear, int languageid,
			int rentalduration, String rentalrate, int length, String replacementcost, String rating, int category) {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		film.setId(id);
		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseyear);
		film.setLanguageId(languageid);
		film.setRentalDuration(rentalduration);

		try {
			film.setRentalRate(Double.parseDouble(rentalrate));
		} catch (NumberFormatException e) {
			System.err.println("Invalid input on rental rate");
			mv.setViewName("editfilmerror");
			return mv;
		}
		film.setLength(length);
		try {
			film.setReplacementCost(Double.parseDouble(replacementcost));
		} catch (NumberFormatException e) {
			System.err.println("Invalid input on rental rate");
			mv.setViewName("editfilmerror");
			return mv;
		}
		film.setRating(rating);
		film.setCategory(filmDAO.findCategoryById(category));

		film = filmDAO.updateFilm(film);

		if (film != null) {
			mv.setViewName("editconfirmation");
			return mv;
		} else {
			mv.setViewName("editfilmerror");
		}
		mv.setViewName("home");
		return mv;
	}

}
