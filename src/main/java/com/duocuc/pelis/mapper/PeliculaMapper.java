package com.duocuc.pelis.mapper;

import com.duocuc.pelis.dto.PeliculaDTO;
import com.duocuc.pelis.entities.PeliculaEntity;
import org.springframework.stereotype.Component;

@Component
public class PeliculaMapper {

    public PeliculaDTO peliculaEntityToDto(PeliculaEntity peliculaEntity) {
        return PeliculaDTO.builder()
                .titulo(peliculaEntity.getTitulo())
                .anio(peliculaEntity.getAnio())
                .director(peliculaEntity.getDirector())
                .genero(peliculaEntity.getGenero())
                .sinopsis(peliculaEntity.getSinopsis())
                .build();
    }

    public PeliculaEntity peliculaDtoToEntity(PeliculaDTO peliculaDTO) {
        return PeliculaEntity.builder()
                .titulo(peliculaDTO.getTitulo())
                .anio(peliculaDTO.getAnio())
                .director(peliculaDTO.getDirector())
                .genero(peliculaDTO.getGenero())
                .sinopsis(peliculaDTO.getSinopsis())
                .build();
    }
}
