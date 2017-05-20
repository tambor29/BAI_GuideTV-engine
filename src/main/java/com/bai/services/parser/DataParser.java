package com.bai.services.parser;

import com.bai.models.MovieInfo;
import com.bai.models.RawData;

import java.util.List;

public interface DataParser {

    List<MovieInfo> parseMovieList(RawData data);
}
