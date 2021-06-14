package com.ruthvik.springdemo.amazonprime.service.implementation;
import com.ruthvik.springdemo.amazonprime.controller.MovieNotFoundException;
import com.ruthvik.springdemo.amazonprime.dao.interfaces.MovieDAO;
import com.ruthvik.springdemo.amazonprime.entity.Movie;
import com.ruthvik.springdemo.amazonprime.service.interfaces.MovieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {
    MovieDAO movieDAO;
    public MovieServiceImpl(MovieDAO movieDAO){
        this.movieDAO = movieDAO;
    }
    @Override
    @Transactional
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    @Override
    @Transactional
    public void saveMovie(Movie theMovie) {
        movieDAO.saveMovie(theMovie);
    }

    @Override
    @Transactional
    public Movie getMovie(int theId) {
        if(movieDAO.getMovie(theId) == null)
            throw new MovieNotFoundException("Movie not found with id: "+theId);
        return movieDAO.getMovie(theId);
    }

    @Override
    @Transactional
    public void deleteMovie(int theId) {
        movieDAO.deleteMovie(theId);
    }
}

