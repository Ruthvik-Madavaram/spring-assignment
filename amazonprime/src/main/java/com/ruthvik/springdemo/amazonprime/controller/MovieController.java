package com.ruthvik.springdemo.amazonprime.controller;
import com.ruthvik.springdemo.amazonprime.converter.MovieConverter;
import com.ruthvik.springdemo.amazonprime.dto.MovieDTO;
import com.ruthvik.springdemo.amazonprime.entity.Customer;
import com.ruthvik.springdemo.amazonprime.entity.Movie;
import com.ruthvik.springdemo.amazonprime.service.interfaces.CustomerService;
import com.ruthvik.springdemo.amazonprime.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MovieController {
    private MovieService movieService;
    private static String redirect = "redirect:/movies";
    private String moviesAttribute = "movies";
    private String movieAttribute = "movie";
    @Autowired
    public  MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MovieConverter movieConverter;
    public Customer getCustomer(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username="none";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        }
        return customerService.getCustomer(username);
    }
    @GetMapping("/movies")
    public String listAllMovies(Model theModel){
        List<Movie> movies= movieService.getAllMovies();
        theModel.addAttribute(moviesAttribute,movies);
        return "list-movies";
    }
    @GetMapping("/add")
    public String showFormForAdd(Model theModel) {
        Movie theMovie = new Movie();
        theModel.addAttribute(movieAttribute, theMovie);
        return "add-movie";
    }
    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") MovieDTO movieDTO) {
        Movie theMovie = movieConverter.convertDTOToEntity(movieDTO);
        movieService.saveMovie(theMovie);
        return redirect;
    }
    @GetMapping("/delete")
    public String deleteMovie(@RequestParam("movieId") int theId){
        movieService.deleteMovie(theId);
        return redirect;
    }
    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("movieId") int theId, Model theModel) {
        Movie theMovie = movieService.getMovie(theId);
        theModel.addAttribute(movieAttribute, theMovie);
        return "add-movie";
    }
    @GetMapping("/watch")
    public String watchMovie(@RequestParam("movieId") int theId, Model theModel){
        int flag = 0;
        Movie theMovie = movieService.getMovie(theId);
        Customer theCustomer = getCustomer();
        for(Movie movie: theCustomer.getMovies()){
            if(theId == movie.getId())
                flag = 1;
        }
        if(flag != 1){
            theCustomer.addMovie(theMovie);
            movieService.saveMovie(theMovie);
        }
        theModel.addAttribute(movieAttribute, theMovie);
        return "watch-movie";
    }
    @GetMapping("/recentlyWatched")
    public String showRecentlyWatched(Model theModel){
        Customer theCustomer = getCustomer();
        theModel.addAttribute(moviesAttribute,theCustomer.getMovies());
        return "recently-watched";
    }
    @GetMapping("/deleteFromRecentlyWatched")
    public String deleteFromRecentlyWatched(@RequestParam("movieId") int theId,Model theModel){
        Customer theCustomer = getCustomer();
        Movie theMovie = movieService.getMovie(theId);
        theCustomer.remove(theMovie);
        movieService.saveMovie(theMovie);
        theModel.addAttribute(moviesAttribute,theCustomer.getMovies());
        return "redirect:/recentlyWatched";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "redirect:/movies";
    }
}
