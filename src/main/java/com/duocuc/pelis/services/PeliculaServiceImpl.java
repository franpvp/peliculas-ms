package com.duocuc.pelis.services;

import com.duocuc.pelis.entities.Pelicula;
import com.duocuc.pelis.repository.PeliculaRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public List<Pelicula> getPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Pelicula getPeliculaById(int id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Pelicula> modificarPelicula(int id, Pelicula peliculaActualizada) {
        return peliculaRepository.findById(id)
                .map(pelicula -> {
                    pelicula.setTitulo(peliculaActualizada.getTitulo());
                    pelicula.setAnio(peliculaActualizada.getAnio());
                    pelicula.setDirector(peliculaActualizada.getDirector());
                    pelicula.setGenero(peliculaActualizada.getGenero());
                    pelicula.setSinopsis(peliculaActualizada.getSinopsis());
                    return peliculaRepository.save(pelicula);
                });
    }

    @Override
    public void eliminarPelicula(int id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public void eliminarAll() {
        peliculaRepository.deleteAll();
    }


}
