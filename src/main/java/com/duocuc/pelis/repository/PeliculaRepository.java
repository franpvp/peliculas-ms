package com.duocuc.pelis.repository;

import com.duocuc.pelis.entities.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Integer> {
}