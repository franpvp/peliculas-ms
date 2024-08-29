package com.duocuc.pelis.controllers;

import com.duocuc.pelis.entities.Pelicula;
import com.duocuc.pelis.services.PeliculaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping("/crear-pelicula")
    public void crearPelicula(@RequestBody Pelicula pelicula) {
        peliculaService.guardarPelicula(pelicula);
    }

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculaService.getPeliculas();
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula getPeliculaById(@PathVariable("id") int id) {
        return peliculaService.getPeliculaById(id);
    }

    @DeleteMapping("/borrar-pelicula/{id}")
    public String eliminarPelicula(@PathVariable int id) {
        peliculaService.eliminarPelicula(id);
        return "Pelicula Eliminada";
    }
}
