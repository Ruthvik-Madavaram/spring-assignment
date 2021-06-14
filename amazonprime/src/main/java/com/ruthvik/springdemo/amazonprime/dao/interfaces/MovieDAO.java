package com.ruthvik.springdemo.amazonprime.dao.interfaces;

import com.ruthvik.springdemo.amazonprime.entity.Movie;

import java.util.List;

public interface MovieDAO {
    public List<Movie> getAllMovies();

    public void saveMovie(Movie theMovie);

    public Movie getMovie(int theId);

    public void deleteMovie(int theId);
}
