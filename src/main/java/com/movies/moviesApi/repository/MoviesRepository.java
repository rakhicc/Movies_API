
package com.movies.moviesApi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.movies.moviesApi.model.Movies;

@Repository
public interface MoviesRepository {
	
	Movies saveMovie(Movies movie);
	Movies searchByName(String name);
    List<Movies> getAllMovies();
}
