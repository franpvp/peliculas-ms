package com.duocuc.pelis.repository;

import com.duocuc.pelis.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}