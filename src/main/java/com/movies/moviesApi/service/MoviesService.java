package com.movies.moviesApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.movies.moviesApi.exception.RecordNotFoundException;
import com.movies.moviesApi.model.InlineResponse201;
import com.movies.moviesApi.model.Movies;
import com.movies.moviesApi.repository.MoviesRepository;



@Component
public class MoviesService {
	@Autowired
	private MoviesRepository moviesRepository;
	
	public void setMoviesRepository(MoviesRepository moviesRepository){
        this.moviesRepository=moviesRepository;
    }
	
	public ResponseEntity < Object > saveMovie(Movies movie) {
		Movies newMovie  = moviesRepository.saveMovie(movie);
		InlineResponse201 inlineResponse201 = new InlineResponse201();
		inlineResponse201.setStatus("created");
		inlineResponse201.setStatusDescription("movie created successfully");
		return new ResponseEntity(inlineResponse201, HttpStatus.CREATED);
		
	}

	public Movies findMovieByName(String name) {
		Movies movie =moviesRepository.searchByName(name);
		return movie;
	}
	
	public List<Movies> getAllMovies() {
		List<Movies> moviesList=moviesRepository.getAllMovies();
		return moviesList;	
	}

}
