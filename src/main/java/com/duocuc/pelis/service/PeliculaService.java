package com.duocuc.pelis.service;
import com.duocuc.pelis.entities.PeliculaEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PeliculaService {

    PeliculaEntity guardarPelicula(PeliculaEntity peliculaEntity);
    List<PeliculaEntity> getPeliculas();
    PeliculaEntity getPeliculaById(int id);
    Optional<PeliculaEntity> modificarPelicula(int id, PeliculaEntity peliculaEntity);
    void eliminarPelicula(int id);
    void eliminarAll();
}
