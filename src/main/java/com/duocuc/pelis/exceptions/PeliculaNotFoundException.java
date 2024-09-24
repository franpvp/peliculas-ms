package com.duocuc.pelis.exceptions;

public class PeliculaNotFoundException extends RuntimeException{
    public PeliculaNotFoundException(String message) {
        super(message);
    }
}
