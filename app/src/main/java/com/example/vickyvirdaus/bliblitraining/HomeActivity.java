package com.example.vickyvirdaus.bliblitraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.vickyvirdaus.bliblitraining.response.ListMovieResponse;
import com.example.vickyvirdaus.bliblitraining.response.MovieResponse;
import com.example.vickyvirdaus.bliblitraining.retrofit.MovieService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {

    private MovieService movieService;
    private MovieAdapter movieAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager movieLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.recyclerView);
        movieLayoutManager = new LinearLayoutManager(this);
        movieLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(movieLayoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        movieService = retrofit.create(MovieService.class);

        movieService.findPopularMovies("4bbbfeaa56287e045385e892563e7168").enqueue(
                new Callback<ListMovieResponse<MovieResponse>>() {
                    @Override
                    public void onResponse(Call<ListMovieResponse<MovieResponse>> call,
                                           Response<ListMovieResponse<MovieResponse>> response) {
                        // HTTP 200
                        if (response.isSuccessful()) {
                            ListMovieResponse<MovieResponse> responseContent = response.body();
                            movieAdapter = new MovieAdapter(responseContent.getResults());
                            recyclerView.setAdapter(movieAdapter);
                        }
                        // HTTP 404, 500
                        else {
                            // toast error
                            Toast.makeText(HomeActivity.this, "HTTP Error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ListMovieResponse<MovieResponse>> call, Throwable t) {
                        Toast.makeText(HomeActivity.this, "HTTP Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
