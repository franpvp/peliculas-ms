package com.duocuc.pelis.services;
import com.duocuc.pelis.entities.Pelicula;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PeliculaService {

    Pelicula guardarPelicula(Pelicula pelicula);
    List<Pelicula> getPeliculas();
    Pelicula getPeliculaById(int id);
    void eliminarPelicula(int id);
}
