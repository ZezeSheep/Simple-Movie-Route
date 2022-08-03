package com.zezesheep.apimovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zezesheep.apimovie.DTO.MovieDTO;
import com.zezesheep.apimovie.service.MovieService;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {
	
	private MovieService movieService;
	
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("")
	public List<MovieDTO> listMovies(){
		return movieService.getAll();
	}

}
