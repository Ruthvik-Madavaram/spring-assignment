package com.ruthvik.springdemo.amazonprime;


import com.ruthvik.springdemo.amazonprime.dao.interfaces.MovieDAO;
import com.ruthvik.springdemo.amazonprime.entity.Movie;
import com.ruthvik.springdemo.amazonprime.service.interfaces.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.Assert.assertEquals;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AmazonprimeApplicationTests {
	@Autowired
	MovieService movieService;
	@MockBean
	MovieDAO movieDAO;
	@Test
	void getMoviesTest() {
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(3,"Money Heist","Series","<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/ZAXA1DV4dtI\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
		Mockito.when(movieDAO.getAllMovies()).thenReturn(movies);
		assertEquals(1,movieService.getAllMovies().size());
	}
	@Test
	void getMovieByIdTest(){
		Mockito.when(movieDAO.getMovie(3)).thenReturn(new Movie(3,"Money Heist","Series","<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/ZAXA1DV4dtI\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>"));
		Movie movie = movieService.getMovie(3);
		assertEquals("Money Heist",movie.getMovieName());
		assertEquals("Series",movie.getMovieGenre());
	}
}
