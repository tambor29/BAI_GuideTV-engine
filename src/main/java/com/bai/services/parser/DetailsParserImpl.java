package com.bai.services.parser;

import com.bai.models.MovieDetails;
import com.bai.models.RawData;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetailsParserImpl implements DetailsParser {
    boolean broadcast = false;
    boolean freshTransmission = true;
    @Override
    public MovieDetails parse(RawData data) {
        Element element = data.getDataSnippet();
        String date = null;


        MovieDetails details = new MovieDetails();
        details.setLongDescription(parseLongDescription(element));
        details.setDuration(parseDuration(element));
        details.setDirector(parseDirector(element));
        details.setActors(parseActors(element));
        details.setBroadcast(parseBroadcast(element));
        if(broadcast){
            date = parseDateInfo(element);
        }
        if(broadcast && freshTransmission){
            details.setEmissionDay(parseDay(date));
            details.setEmissionMonth(parseMonth(date));
            details.setEmissionYear(parseYear(date));
            details.setHour(parseHour(element));
            details.setMinute(parseMinute(element));
            details.setStationLogo(parseLogo(element));
            details.setStation(parseStation(element));
        }

        return details;
    }

    private String parseLongDescription(Element element){
        String result = element
                .select("div.markdown")
                .first()
                .text();

        return trimContent(result);
    }

    private String parseDuration(Element element) {
        String result = element
                .select("div.daneZajawka ul li")
                .first()
                .text()
                .split(",")[0];
        return trimContent(result);

    }

    private String parseDirector(Element element){
        String result = element
                .select("div.daneZajawka ul li:nth-child(2)")
                .text();
        return trimContent(result);
    }

    private List<String> parseActors(Element element){
        List<String> actors = new ArrayList<>();
        Elements result = element
                .select("div.ludzie")
                .select("ul.row")
                .select("div.osoba");

        String tmp;
        for(Element el : result) {
            tmp = el.text();
            if(tmp.contains("jako"))
                actors.add(tmp);
        }

        return actors;
    }

    private boolean parseBroadcast(Element element){
        Element broadcast = element
                .select("div.emisje")
                .first();
        this.broadcast = (broadcast != null);
        return broadcast != null;
    }


    private String parseDateInfo(Element element) {
        String[] tmp;
        String extractedDate = element
                .select("span.emisjaDzien")
                .first()
                .text()
                .toLowerCase();

        switch (extractedDate){
            case "dzisiaj":
                extractedDate = today();
                break;
            case "jutro":
                extractedDate = tomorrow();
                break;
            default:
                tmp = extractedDate.split(" ");
                extractedDate = normalDate(tmp[1]);
                break;
        }
        return extractedDate;
    }

    private String today(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.now().format( formatter);
    }

    private String tomorrow(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.now().plusDays(1).format(formatter);
    }

    private String normalDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate parsedDate = LocalDate.parse(date, formatter);
        if(!parsedDate.isAfter(LocalDate.now())) {
            freshTransmission = false;
            broadcast = false;
            return "";
        }
        else {
            freshTransmission = true;
            return date;
        }
    }

    private String parseDay(String date){
        return date.split("\\.")[0];

    }

    private String parseMonth(String date){
        return date.split("\\.")[1];
    }

    private String parseYear(String date){
        return date.split("\\.")[2];
    }


    private String parseHour(Element element) {
        return element
                .select("span.emisjaGodzina")
                .first()
                .text()
                .split(":")[0];
    }

    private String parseMinute(Element element) {
        return element
                .select("span.emisjaGodzina")
                .first()
                .text()
                .split(":")[1];
    }

    private String trimContent(String text){
        return (text != null)? text.trim(): "";
    }

    private String parseLogo(Element element) {
        return element
                .select("div.emisje div.logo a img")
                .attr("src");
    }

    private String parseStation(Element element) {
        return element
                .select("div.emisjaSzczegoly p:nth-child(2) a")
                .first()
                .text();
    }
}
