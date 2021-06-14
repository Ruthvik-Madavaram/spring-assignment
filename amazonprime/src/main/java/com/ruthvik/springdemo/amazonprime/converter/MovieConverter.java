package com.ruthvik.springdemo.amazonprime.converter;

import com.ruthvik.springdemo.amazonprime.dto.MovieDTO;
import com.ruthvik.springdemo.amazonprime.entity.Movie;
import org.springframework.stereotype.Controller;

@Controller
public class MovieConverter {
    public MovieDTO entityToDTO(Movie theMovie){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(theMovie.getId());
        movieDTO.setMovieName(theMovie.getMovieName());
        movieDTO.setMovieGenre(theMovie.getMovieGenre());
        movieDTO.setMovieLink(theMovie.getMovieLink());
        return movieDTO;
    }
    public Movie convertDTOToEntity(MovieDTO movieDTO){
        Movie theMovie = new Movie();
        theMovie.setId(movieDTO.getId());
        theMovie.setMovieName(movieDTO.getMovieName());
        theMovie.setMovieGenre(movieDTO.getMovieGenre());
        theMovie.setMovieLink(movieDTO.getMovieLink());
        return theMovie;
    }
}
