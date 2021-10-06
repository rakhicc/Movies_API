package com.movies.moviesApi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.movies.moviesApi.model.InlineResponse201;
import com.movies.moviesApi.model.Movies;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class, webEnvironment=WebEnvironment.RANDOM_PORT)
public class ApplicationIntegrationTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testAddMovie() {
		Movies movie =new Movies();
		movie.setName("Avengers");
		movie.setRating(3);
		movie.setAgeLimit(5);
		ResponseEntity<InlineResponse201> responseEntity =this.restTemplate.postForEntity("http://localhost:"+ port+"/movies/", movie, InlineResponse201.class);
	assertEquals(201,responseEntity.getStatusCodeValue());
	}
	@Test
	public void testGetMovieByName() {
		String movieName = "Avengers: Endgame";
		ResponseEntity < Movies > responseEntity =this.restTemplate.getForEntity("http://localhost:"+ port+"/movies/"+movieName,  Movies.class);
	assertEquals(200,responseEntity.getStatusCodeValue());
	}
	
	
}
