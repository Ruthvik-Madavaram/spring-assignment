package com.ruthvik.springdemo.amazonprime.dto;

import lombok.Data;

@Data
public class MovieDTO {
    private int id;
    private String movieName;
    private String movieGenre;
    private String movieLink;
}
