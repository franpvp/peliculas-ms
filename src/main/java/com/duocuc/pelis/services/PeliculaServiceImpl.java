package com.duocuc.pelis.services;

import com.duocuc.pelis.entities.Pelicula;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    private final List<Pelicula> listaPeliculas = new ArrayList<>();

    public PeliculaServiceImpl() {
        // Inicialización de objetos Pelicula
        listaPeliculas.add(new Pelicula("Mi Película Favorita", 1, 2020, "Director Ejemplo", "Drama", "Una breve descripción de la película."));
        listaPeliculas.add(new Pelicula("Otra Película", 2, 2021, "Director 2", "Comedia", "Otra breve descripción de la película."));
        listaPeliculas.add(new Pelicula("Película 3", 3, 2019, "Director 3", "Acción", "Descripción de la película 3."));
        listaPeliculas.add(new Pelicula("Película 4", 4, 2022, "Director 4", "Thriller", "Descripción de la película 4."));
        listaPeliculas.add(new Pelicula("Película 5", 5, 2023, "Director 5", "Ciencia Ficción", "Descripción de la película 5."));
    }

    @Override
    public List<Pelicula> getPeliculas() {
        return listaPeliculas;
    }

    @Override
    public Optional<Pelicula> getPeliculaById(int id) {
        return listaPeliculas.stream()
                .filter(pelicula -> pelicula.getId() == id)
                .findFirst();
    }

}
