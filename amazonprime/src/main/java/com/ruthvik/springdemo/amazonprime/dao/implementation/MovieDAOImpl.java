package com.ruthvik.springdemo.amazonprime.dao.implementation;

import com.ruthvik.springdemo.amazonprime.dao.interfaces.MovieDAO;
import com.ruthvik.springdemo.amazonprime.entity.Movie;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class MovieDAOImpl implements MovieDAO {
    private EntityManager entityManager;
    public MovieDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Movie> getAllMovies() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Movie",Movie.class).getResultList();
    }

    @Override
    public void saveMovie(Movie theMovie) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(theMovie);
    }

    @Override
    public Movie getMovie(int theId) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(Movie.class,theId);
    }

    @Override
    public void deleteMovie(int theId) {
        Session session = entityManager.unwrap(Session.class);
        session.createQuery("delete from Movie where id = "+theId).executeUpdate();
    }
}

