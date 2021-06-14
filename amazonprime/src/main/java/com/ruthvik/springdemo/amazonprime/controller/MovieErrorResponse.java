package com.ruthvik.springdemo.amazonprime.controller;

import lombok.Data;

@Data
public class MovieErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
