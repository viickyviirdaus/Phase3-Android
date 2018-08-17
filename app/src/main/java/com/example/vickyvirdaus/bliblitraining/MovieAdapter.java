package com.example.vickyvirdaus.bliblitraining;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vickyvirdaus.bliblitraining.response.MovieResponse;


import java.util.List;

/**
 * Created by Vicky Virdaus on 8/17/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<MovieResponse> data;

    class MovieViewHolder extends RecyclerView.ViewHolder{

        private TextView textRating;
        private ImageView poster;

        public MovieViewHolder(View itemView) {
            super(itemView);
            textRating = itemView.findViewById(R.id.rate);
            poster = itemView.findViewById(R.id.poster);
        }
    }

    public MovieAdapter(List<MovieResponse> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_item_list_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MovieResponse item = data.get(position);
        holder.textRating.setText(String.valueOf(item.getRate()));
        Glide.with(holder.poster.getContext())
                .load("http://image.tmdb.org/t/p/w185/" +item.getPosterPath()).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
