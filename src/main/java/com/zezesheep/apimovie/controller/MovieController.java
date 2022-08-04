package com.zezesheep.apimovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{id}")
	public MovieDTO getMovieById(@PathVariable(value="id") Long id) throws Exception{
		return movieService.getOne(id);
	}
	
	@PostMapping("")
	public MovieDTO saveMovie(@RequestBody MovieDTO newMovie) {
		return movieService.create(newMovie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable(value="id") Long id) {
		movieService.delete(id);
	}
	
	@PutMapping("")
	public MovieDTO updateMovie(@RequestBody MovieDTO updatedMovie) {
		return movieService.update(updatedMovie);
	}


}
