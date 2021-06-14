package com.ruthvik.springdemo.amazonprime.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "movie_genre")
    private String movieGenre;
    @Column(name = "movie_link")
    private String movieLink;
    @ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="customer_movie",
            joinColumns=@JoinColumn(name="movie_id"),
            inverseJoinColumns=@JoinColumn(name="username")
    )
    private List<Customer> customers;
    public Movie(){}
    public Movie(int id, String movieName, String movieGenre, String movieLink) {
        this.id = id;
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.movieLink = movieLink;
    }

    public void addCustomer(Customer theCustomer) {
        if (customers == null) {
            customers = new ArrayList<>();
        }
        customers.add(theCustomer);
    }
}
