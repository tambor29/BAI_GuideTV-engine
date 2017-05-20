package com.bai.models;

public class MovieInfo {
    String movieTitle;
    String releaseDate;
    String movieType;
    String country;
    String refToMoreInfo;
    String shortDescription;
    String movieImage;

    public MovieInfo(){}

    MovieInfo(MovieInfoBuilder mib){
        movieTitle = mib.movieTitle;
        releaseDate = mib.releaseDate;
        movieType = mib.movieType;
        country = mib.country;
        refToMoreInfo = mib.refToMoreInfo;
        shortDescription = mib.shortDescription;
        movieImage = mib.movieImage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRefToMoreInfo() {
        return refToMoreInfo;
    }

    public void setRefToMoreInfo(String refToMoreInfo) {
        this.refToMoreInfo = refToMoreInfo;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLinkDoZdjecia() {
        return movieImage;
    }

    public void setLinkDoZdjecia(String linkDoZdjecia) {
        this.movieImage = linkDoZdjecia;
    }

}
