package com.duocuc.pelis.services;
import com.duocuc.pelis.entities.Pelicula;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PeliculaService {

    Pelicula guardarPelicula(Pelicula pelicula);
    List<Pelicula> getPeliculas();
    Pelicula getPeliculaById(int id);
    Optional<Pelicula> modificarPelicula(int id, Pelicula pelicula);
    void eliminarPelicula(int id);
    void eliminarAll();
}
