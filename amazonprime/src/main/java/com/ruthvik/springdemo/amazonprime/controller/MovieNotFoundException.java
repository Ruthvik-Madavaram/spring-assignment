package com.ruthvik.springdemo.amazonprime.controller;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(String message){
        super(message);
    }
}
