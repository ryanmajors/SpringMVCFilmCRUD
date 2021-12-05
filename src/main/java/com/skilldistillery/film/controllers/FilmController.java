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
	
	@RequestMapping({"/", "home.do"})
	public String home(Model model) {
		model.addAttribute("TEST", "Hello, Spring MVC!");
		return "home";
	}
	
	@RequestMapping({"addfilm"})
	public String addFilm(Model model) {
		model.addAttribute("TEST", "Hello, Spring MVC!");
		return "addfilm";
	}
	
	@RequestMapping(path="getfilmbyid.do", params="filmid", method=RequestMethod.GET)
	public ModelAndView getFilmById(int filmid) {
		ModelAndView mv = new ModelAndView();
		Film film = filmDAO.findFilmById(filmid);
		mv.addObject("film", film);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(path="getfilmbykeyword.do", params="filmphrase", method=RequestMethod.GET)
	public ModelAndView getFilmsByFilmPhrase(String filmphrase) {
		ModelAndView mv = new ModelAndView();
		List<Film> films = filmDAO.findFilmByFilmWordSearch(filmphrase);
		mv.addObject("films", films);
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(path="addnewfilm.do", method=RequestMethod.GET)
	public ModelAndView addNewFilmToDB(String title, String description, int releaseyear, int languageid, int rentalduration, String rentalrate, int length, String replacementcost, String rating ) {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		film.setTitle(title);
		film.setDescription(description);
		film.setReleaseYear(releaseyear);
		film.setLanguageId(languageid);
		film.setRentalDuration(rentalduration);
		film.setRentalRate(Double.parseDouble(rentalrate));
		film.setLength(length);
		film.setReplacementCost(Double.parseDouble(replacementcost));
		film.setRating(rating);
//		film.setFeatures(features);

		film = filmDAO.addNewFilm(film);
		mv.addObject("film", film);
		mv.setViewName("result");
		return mv;
	}

}
