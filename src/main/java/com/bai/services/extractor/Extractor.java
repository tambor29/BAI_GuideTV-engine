package com.bai.services.extractor;

import com.bai.models.RawData;

import java.io.IOException;

public interface Extractor  {
    String SERVICE_URL = "http://www.telemagazyn.pl";

    RawData extractMovieList(String title) throws IOException;
}
