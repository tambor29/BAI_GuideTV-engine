package com.bai.services.extractor;

import com.bai.models.RawData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ExtractorImpl implements Extractor {
    @Override
    public RawData extractMovieList(String title) throws IOException {
        Element dataSnippet;
        dataSnippet = extractDataSnippet(title);
        return new RawData(dataSnippet);
    }

     Element extractDataSnippet(String title) throws IOException {
         Document document = Jsoup.connect(SERVICE_URL+"/szukaj/?q="+title)
                 .data("query", "Java")
                 .userAgent("Mozilla")
                 .cookie("auth", "token")
                 .timeout(10000)
                 .get();

         return document
                 .getElementsByClass("wynikiProg")
                 .first();
    }
}
