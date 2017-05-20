package com.bai.controllers;

import com.bai.models.MovieDetails;
import com.bai.models.MovieInfo;
import com.bai.models.RawData;
import com.bai.services.extractor.Extractor;
import com.bai.services.parser.DataParser;
import com.bai.services.parser.DataParserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    Extractor extractor;
    @Autowired
    DataParser parser;

    @CrossOrigin
    @RequestMapping("/list")
    public List<String> sendListOfMovies(){
        List<String> movies = new ArrayList<>();
        movies.add("Captain America");
        movies.add("Iron Man");
        movies.add("Harry Potter");
        try {
            RawData shrek = extractor.extractMovieList("shrek");
            parser = new DataParserImpl();
            parser.parseMovieList(shrek);

        }
        catch (IOException  e){
            System.out.println("Error");
        }

        return movies;
    }


    public MovieDetails sendMovieDetails(){
        MovieDetails details = new MovieDetails();

        return details;
    }
    @CrossOrigin
    @RequestMapping("/list-test")
    public List<MovieInfo> mokMoviesList(){
        List<MovieInfo> movies = new ArrayList<>();

        MovieInfo pierwszy = new MovieInfo();
        pierwszy.setCountry("USA");
        pierwszy.setLinkDoZdjecia("https://d-tm.ppstatic.pl/83/9b/cc28a1f0183cd1f328a835365503.200.jpg");
        pierwszy.setMovieTitle("Thor");
        pierwszy.setMovieType("Film przygodowy");
        pierwszy.setReleaseDate("2011");
        pierwszy.setShortDescription("Ekranizacja komiksu Marvela. Nordycki bóg Thor zostaje wygnany z Asgardu przez ojca, Odyna. Ma żyć jako śmiertelnik, by nauczyć się pokory. Źródło jego mocy - młot Mjöllnir - zostaje mu odebrane.");
        pierwszy.setRefToMoreInfo("337743");

        MovieInfo drugi = new MovieInfo();
        drugi.setCountry("Drugi Kraj");
        drugi.setLinkDoZdjecia("https://d-tm.ppstatic.pl/a3/17/544e10ea07fab40a692130b08d59.200.jpg");
        drugi.setMovieTitle("Drugi tytul");
        drugi.setMovieType("Drugi gatunek");
        drugi.setReleaseDate("2000");
        drugi.setShortDescription("To jest opis drugiego filmu");
        drugi.setRefToMoreInfo("drugie id");


        MovieInfo trzeci = new MovieInfo();
        trzeci.setCountry("trzeci Kraj");
        trzeci.setLinkDoZdjecia("https://d-tm.ppstatic.pl/7e/9f/997330bfaafb9d9ef5f096e7415b.200.jpg");
        trzeci.setMovieTitle("trzeci tytul");
        trzeci.setMovieType("trzeci gatunek");
        trzeci.setReleaseDate("2000");
        trzeci.setShortDescription("To jest opis trzeciego filmu");
        trzeci.setRefToMoreInfo("trzecie id");

        movies.add(pierwszy);
        movies.add(drugi);
        movies.add(trzeci);

        return movies;
    }

    @CrossOrigin
    @RequestMapping("/detale-test")
    public MovieDetails mokMovieDetails(){
        MovieDetails details = new MovieDetails();
        details.setDirector("Lilly Wachowski, Lana Wachowski");
        details.setDuration("138 minut");
        details.setEmissionDay("19");
        details.setEmissionMonth("5");
        details.setEmissionYear("2017");
        details.setHour("23");
        details.setMinute("10");
        details.setStation("TVN");
        details.setStationLogo("https://d-tm.ppstatic.pl/loga_stacji/tvn.png?0");
        details.setLongDescription("Maszyny odkryły lokalizację Syjonu i wysyłają w stronę miasta armię strażników, która ma rozprawić się z ludźmi. Obdarzony niezwykłymi zdolnościami Neo i jego sprzymierzeńcy muszą ich powstrzymać. Za radą Wyroczni wyruszają na poszukiwanie Klucznika, który może otworzyć drzwi prowadzące do Źródła. Wyprawę utrudnia agent Smith, który nie tylko udoskonalił metody walki, ale nauczył się replikować.");
        List<String> aktorzy = new ArrayList<>();
        aktorzy.add("Keanu Reeves jako Neo");
        aktorzy.add("Laurence Fishburne jako Morfeusz");
        aktorzy.add("Jada pinket Smith jako Niobe");
        details.setActors(aktorzy);
        return details;
    }
}
