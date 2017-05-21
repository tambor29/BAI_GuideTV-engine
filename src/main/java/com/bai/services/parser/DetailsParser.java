package com.bai.services.parser;

import com.bai.models.MovieDetails;
import com.bai.models.RawData;

public interface DetailsParser {
    MovieDetails parse(RawData data);
}
