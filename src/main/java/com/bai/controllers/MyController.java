package com.bai.controllers;

import com.bai.models.MovieDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    
    @CrossOrigin
    @RequestMapping("/list")
    public List<String> sendListOfMovies(){
        List<String> movies = new ArrayList<>();
        movies.add("Captain America");
        movies.add("Iron Man");
        movies.add("Harry Potter");

        return movies;
    }


    public MovieDetails sendMovieDetails(){
        MovieDetails details = new MovieDetails();

        return details;
    }
}
