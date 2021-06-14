package com.ruthvik.springdemo.amazonprime.entity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Data
public class Customer {
    @Id
    @Column(name = "username")
    private String userName;
    @ManyToMany(fetch= FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="customer_movie",
            joinColumns=@JoinColumn(name="username"),
            inverseJoinColumns=@JoinColumn(name="movie_id")
    )
    private List<Movie> movies;
    public void addMovie(Movie theMovie) {
        if (movies == null) {
            movies = new ArrayList<>();
        }
        movies.add(theMovie);
    }

    public void remove(Movie theMovie) {
        movies.remove(theMovie);
    }
}
