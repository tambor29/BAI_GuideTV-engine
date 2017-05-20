package com.bai.services.extractor;

import com.bai.models.RawData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExtractorImpl implements Extractor {

    @Override
    public RawData extractMovieList(String title, Operation operation) throws IOException {
        Element dataSnippet;
        dataSnippet = extractDataSnippet(title,Operation.SEARCH );
        return new RawData(dataSnippet);
    }

    Element extractDataSnippet(String title, Operation operation) throws IOException {
        Element result = null;
         Document document = Jsoup.connect(SERVICE_URL+operation+title)
                 .data("query", "Java")
                 .userAgent("Mozilla")
                 .cookie("auth", "token")
                 .timeout(10000)
                 .get();

        switch(operation){
            case SEARCH:
                result = document
                        .select(".wynikiProg")
                        .first();
                break;

            case DETAIL:
                result = document
                        .select("#audycja")
                        .first();
                break;
        }
        return result;

    }

}


