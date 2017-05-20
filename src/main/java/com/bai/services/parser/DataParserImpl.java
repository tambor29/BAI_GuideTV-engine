package com.bai.services.parser;

import com.bai.models.MovieInfo;
import com.bai.models.RawData;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.awt.peer.SystemTrayPeer;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataParserImpl implements DataParser {
    public enum InfoType{
        COUNTRY,
        YEAR
    }

    @Override
    public List<MovieInfo> parseMovieList(RawData data) {
        List<MovieInfo> movies = data
                .getDataSnippet()
                .select("li")
                .stream()
                .map(this::parseMovieInformation)
                .collect(Collectors.toList());

        return movies;
    }

    private MovieInfo parseMovieInformation(Element li){
        MovieInfo movie = new MovieInfo();
        movie.setLinkDoZdjecia(parseMovieImage(li));
        movie.setRefToMoreInfo(parseLinkToMoreInfo(li));
        movie.setShortDescription(parseMovieDescription(li));
        movie.setCountry(parseMovieCountryOrYear(li, InfoType.COUNTRY));
        movie.setMovieTitle(parseMovieTitle(li));
        movie.setReleaseDate(parseMovieCountryOrYear(li, InfoType.YEAR));
        movie.setMovieType(parseMovieType(li));
        return movie;
    }

    private String parseLinkToMoreInfo(Element element) {
        return element
                .select("a")
                .attr("href");
    }

    private String parseMovieImage(Element element){
        String imageLink = element
                .select("a i")
                .attr("style")
        ;

        return imageLink
                .substring(imageLink.indexOf("(")+2, imageLink.indexOf(")")-1)
        ;
    }

    private String parseMovieTitle(Element element){
        return element
                .select("a h3")
                .text();
    }

    private String parseMovieCountryOrYear(Element element, InfoType type){
        String country = element
                .select("a p span")
                .first()
                .text();
        return country
                .split(" ")[type.ordinal()];
    }

    private String parseMovieType(Element element){
        return element
                .select("a p span:last-child")
                .text();
    }

    private String parseMovieDescription(Element element) {
        return element
                .select("a div")
                .text();
    }
}
