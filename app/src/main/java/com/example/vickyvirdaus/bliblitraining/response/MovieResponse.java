package com.example.vickyvirdaus.bliblitraining.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vicky Virdaus on 8/17/2018.
 */

public class MovieResponse {
    @SerializedName("poster_path")
    private String posterPath;
    private String title;
    @SerializedName("vote_average")
    private Double rate;

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public Double getRate() {
        return rate;
    }
}
