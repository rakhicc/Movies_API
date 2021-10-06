package com.movies.moviesApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.moviesApi.model.Movies;
import com.movies.moviesApi.service.MoviesService;



@RestController
@RequestMapping("/movies")
public class MoviesController {

	@Autowired
	MoviesService moviesService;
	
	@PostMapping(value = "/")   
    public ResponseEntity < Object > createMovies(@RequestBody @Valid Movies movies) {
    	ResponseEntity < Object > response  = moviesService.saveMovie(movies);
    	
    	return response;
    }
	
	@GetMapping(value = "/{name}")
    public ResponseEntity < Movies > getMovieByName(@PathVariable("name") String name) {
    	Movies movie  = moviesService.findMovieByName(name);
    	return new ResponseEntity<Movies>(movie, HttpStatus.OK); 
    }
	
	@GetMapping(value = "/")
    public ResponseEntity < List<Movies> > getAllMovies() {
		List<Movies> moviesList  = moviesService.getAllMovies();
    	return new ResponseEntity<List<Movies>>(moviesList, HttpStatus.OK); 
    }
}
