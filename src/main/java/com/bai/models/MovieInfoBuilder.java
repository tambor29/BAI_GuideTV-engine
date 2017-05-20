package com.bai.models;

public class MovieInfoBuilder {
    String movieTitle;
    String releaseDate;
    String movieType;
    String country;
    String refToMoreInfo;
    String shortDescription;
    String movieImage;


    public  MovieInfoBuilder movieTitle(String movieTitle){
        this.movieTitle = movieTitle;
        return this;
    }

    public MovieInfoBuilder releaseDate(String releaseDate){
        this.releaseDate = releaseDate;
        return this;
    }

    public MovieInfoBuilder movieType(String movieType){
        this.movieType = movieType;
        return this;
    }

    public MovieInfoBuilder country(String country){
        this.country = country;
        return this;
    }

    public MovieInfoBuilder refToMoreInfo(String ref){
        this.refToMoreInfo = ref;
        return this;
    }


    public MovieInfoBuilder shortDescription(String description){
        this.shortDescription = description;
        return this;
    }

    public MovieInfoBuilder movieImage(String movieImage){
        this.movieImage = movieImage;
        return this;
    }

    public MovieInfo build(){
        return new MovieInfo(this);
    }


}
