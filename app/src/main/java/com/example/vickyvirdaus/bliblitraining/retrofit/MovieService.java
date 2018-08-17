package com.example.vickyvirdaus.bliblitraining.retrofit;

import com.example.vickyvirdaus.bliblitraining.response.ListMovieResponse;
import com.example.vickyvirdaus.bliblitraining.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vicky Virdaus on 8/17/2018.
 */

public interface MovieService {
    @GET("movie/popular")
    Call<ListMovieResponse<MovieResponse>> findPopularMovies(@Query("api_key") String apiKey);
}
