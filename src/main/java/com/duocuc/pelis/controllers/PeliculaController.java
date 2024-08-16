package com.duocuc.pelis.controllers;

import com.duocuc.pelis.entities.Pelicula;
import com.duocuc.pelis.services.PeliculaService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculaService.getPeliculas();

    }

    @GetMapping("/peliculas/{id}")
    public Pelicula getPeliculaById(@PathVariable("id") int id) {
        Optional<Pelicula> pelicula = peliculaService.getPeliculaById(id);
        return pelicula.orElseThrow(() -> new RuntimeException("No se encontró la película con el ID: " + id));

    }
}
