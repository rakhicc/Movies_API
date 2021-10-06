package com.movies.moviesApi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.movies.moviesApi.exception.InvalidInputException;
import com.movies.moviesApi.exception.RecordNotFoundException;
import com.movies.moviesApi.model.Movies;
import com.movies.moviesApi.repository.MoviesRepository;



@Repository
public class MoviesDao implements MoviesRepository{
	private final MongoTemplate mongoTemplate;

	MoviesDao(MongoTemplate mongoTemplate) {
	this.mongoTemplate= mongoTemplate;
	}

	@Override
	public Movies saveMovie(Movies movie) {
		List<Movies> moviesList=mongoTemplate.findAll(Movies.class);
		boolean movieWithSameNameExists=false;
		if(!CollectionUtils.isEmpty(moviesList)) {
			for(Movies item:moviesList){
				if(item.getName().equalsIgnoreCase(movie.getName())) {
					movieWithSameNameExists=true;
					break;
				}
			}
		}
		if(movieWithSameNameExists) {
			throw new InvalidInputException("Movie with same name already exists");
		} 
		 mongoTemplate.save(movie);	
		return movie;
	}

	@Override
	public Movies searchByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		
		Movies movie = mongoTemplate.findOne(query, Movies.class);
		if (movie == null) {
			throw new RecordNotFoundException("Movie not Found");
		}
		return movie;
	}

	@Override
	public List<Movies> getAllMovies() {
		List<Movies> moviesList=mongoTemplate.findAll(Movies.class);
		if(CollectionUtils.isEmpty(moviesList)) {
			throw new RecordNotFoundException("Movies not Found");
		}
		return moviesList;	
	}

}
