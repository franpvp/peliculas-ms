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

    private final List<Pelicula> listaPeliculas = new ArrayList<>();

    @Autowired
    private PeliculaRepository peliculaRepository;

    @PostConstruct
    public void init() {
        // Inicialización de objetos Pelicula
        listaPeliculas.add(new Pelicula("Inception", 2010, "Christopher Nolan", "Ciencia Ficción", "Un ladrón que roba secretos corporativos mediante el uso de la tecnología de compartir sueños es dado la tarea inversa: implantar una idea en la mente de un CEO."));
        listaPeliculas.add(new Pelicula("Parasite", 2019, "Bong Joon-ho", "Drama", "Una historia sobre la coexistencia y el conflicto entre dos familias de diferentes clases sociales."));
        listaPeliculas.add(new Pelicula("The Dark Knight", 2008, "Christopher Nolan", "Acción", "Batman debe aceptar uno de los mayores desafíos psicológicos y físicos para derrotar al Joker."));
        listaPeliculas.add(new Pelicula("Pulp Fiction", 1994, "Quentin Tarantino", "Thriller", "Las vidas de dos matones de la mafia, una esposa de gánster, un boxeador y un par de bandidos se entrelazan en cuatro relatos de violencia y redención."));
        listaPeliculas.add(new Pelicula("Interstellar", 2014, "Christopher Nolan", "Ciencia Ficción", "Un grupo de exploradores viajan a través de un agujero de gusano en el espacio en un intento por asegurar el futuro de la humanidad."));
        listaPeliculas.add(new Pelicula("The Matrix", 1999, "The Wachowskis", "Ciencia Ficción", "Un programador descubre que el mundo en el que vive es una simulación virtual controlada por una inteligencia artificial, y se une a un grupo de rebeldes para luchar por la libertad de la humanidad."));

        for (Pelicula pelicula : listaPeliculas) {
            peliculaRepository.save(pelicula);
        }
    }

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
    public void eliminarPelicula(int id) {
        peliculaRepository.deleteById(id);
    }

}
