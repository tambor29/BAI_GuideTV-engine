package com.bai.services.parser;

import com.bai.models.MovieInfo;
import com.bai.models.MovieInfoBuilder;
import com.bai.models.RawData;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class DataParserImpl implements DataParser {

    private enum InfoType{
        COUNTRY,
        YEAR
    }

    @Override
    public List<MovieInfo> parseMovieList(RawData data) {
         return  data
                .getDataSnippet()
                .select("li")
                .stream()
                .map(this::parseMovieInformation)
                .collect(Collectors.toList());

    }

    private MovieInfo parseMovieInformation(Element li){
        MovieInfoBuilder movieBuilder = new MovieInfoBuilder();

        return  movieBuilder
                .movieImage(parseMovieImage(li))
                .refToMoreInfo(parseLinkToMoreInfo(li))
                .shortDescription(parseMovieDescription(li))
                .country(parseMovieCountryOrYear(li, InfoType.COUNTRY))
                .movieTitle(parseMovieTitle(li))
                .releaseDate(parseMovieCountryOrYear(li, InfoType.YEAR))
                .movieType(parseMovieType(li))
                .build();
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

        String[] split = country.split(" ");
        return (split.length > type.ordinal())? split[type.ordinal()]: "";
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
