package com.movies.moviesApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


/**
 * Hello movies API!
 *
 */
@EntityScan(basePackages = "com.movies.moviesApi")
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello movies API!" );
        SpringApplication.run(App.class, args);
    }
}
