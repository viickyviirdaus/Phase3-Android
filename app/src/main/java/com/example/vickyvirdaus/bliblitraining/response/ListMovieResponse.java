package com.example.vickyvirdaus.bliblitraining.response;

import java.util.List;

/**
 * Created by Vicky Virdaus on 8/17/2018.
 */

public class ListMovieResponse<T> {
    private List<T> results;

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
