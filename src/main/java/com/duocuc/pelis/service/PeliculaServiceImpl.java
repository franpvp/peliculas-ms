package com.duocuc.pelis.service;

import com.duocuc.pelis.entities.PeliculaEntity;
import com.duocuc.pelis.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    public PeliculaEntity guardarPelicula(PeliculaEntity peliculaEntity) {
        return peliculaRepository.save(peliculaEntity);
    }

    @Override
    public List<PeliculaEntity> getPeliculas() {
        return peliculaRepository.findAll();
    }

    @Override
    public PeliculaEntity getPeliculaById(int id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<PeliculaEntity> modificarPelicula(int id, PeliculaEntity peliculaEntityActualizada) {
        return peliculaRepository.findById(id)
                .map(peliculaEntity -> {
                    peliculaEntity.setTitulo(peliculaEntityActualizada.getTitulo());
                    peliculaEntity.setAnio(peliculaEntityActualizada.getAnio());
                    peliculaEntity.setDirector(peliculaEntityActualizada.getDirector());
                    peliculaEntity.setGenero(peliculaEntityActualizada.getGenero());
                    peliculaEntity.setSinopsis(peliculaEntityActualizada.getSinopsis());
                    return peliculaRepository.save(peliculaEntity);
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
