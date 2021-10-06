package com.movies.moviesApi.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class Movies {
	
	@Id
    private String id;
    private String name;
    private String year;
    private List<String> genres;
    private int ageLimit;
    private int rating;
    private List<Actors> actors;
    private String synopsis;
    private Director director;
    
    
    
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	@NotNull(message = "Please provide Movie name")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the genres
	 */
	public List<String> getGenres() {
		return genres;
	}
	/**
	 * @param genres the genres to set
	 */
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	/**
	 * @return the ageLimit
	 */
	public int getAgeLimit() {
		return ageLimit;
	}
	/**
	 * @param ageLimit the ageLimit to set
	 */
	public void setAgeLimit(int ageLimit) {
		this.ageLimit = ageLimit;
	}
	/**
	 * @return the rating
	 */
	@Min(value = 0, message = "Rating should not be less than 0")
    @Max(value = 5, message = "Rating should not be greater than 5")
	public int getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	/**
	 * @return the actorsList
	 */
	
	/**
	 * @return the synopsis
	 */
	public String getSynopsis() {
		return synopsis;
	}
	/**
	 * @return the actors
	 */
	public List<Actors> getActors() {
		return actors;
	}
	/**
	 * @param actors the actors to set
	 */
	public void setActors(List<Actors> actors) {
		this.actors = actors;
	}
	/**
	 * @param synopsis the synopsis to set
	 */
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	/**
	 * @return the director
	 */
	public Director getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(Director director) {
		this.director = director;
	}

}
