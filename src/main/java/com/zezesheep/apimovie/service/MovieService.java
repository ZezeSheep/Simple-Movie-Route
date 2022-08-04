package com.zezesheep.apimovie.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zezesheep.apimovie.DTO.MovieDTO;
import com.zezesheep.apimovie.entity.Movie;
import com.zezesheep.apimovie.repository.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository movieRepository;
	
	private ModelMapper modelMapper;
	
	
	@Autowired
	public MovieService(MovieRepository movieRepository, ModelMapper modelMapper) {
		this.movieRepository = movieRepository;
		this.modelMapper = modelMapper;
	}
	
	public List<MovieDTO> getAll(){
		List<MovieDTO> moviesReturned = new ArrayList<>();
		List<Movie> moviesFromTable = movieRepository.findAll();
		moviesFromTable.forEach(movie -> moviesReturned.add(modelMapper.map(movie, MovieDTO.class)));
		
		return moviesReturned;
	}
	
	public MovieDTO getOne(Long id) throws Exception{
		Movie movieFromTable = movieRepository.findById(id).orElseThrow(() -> new Exception("Movie " + id +" not found."));
		return modelMapper.map(movieFromTable, MovieDTO.class);
	}
	
	public MovieDTO create(MovieDTO newMovie) {
		Movie moveToBeSaved = modelMapper.map(newMovie, Movie.class);
		Movie savedMovie = movieRepository.save(moveToBeSaved);
		return modelMapper.map(savedMovie, MovieDTO.class);
	}

	public void delete(Long id) {
		movieRepository.deleteById(id);
	}
	
	public MovieDTO update(MovieDTO movieUpdated) {
		Movie moveToBeSaved = modelMapper.map(movieUpdated, Movie.class);
		Movie savedMovie = movieRepository.save(moveToBeSaved);
		return modelMapper.map(savedMovie, MovieDTO.class);
	}
	

}
