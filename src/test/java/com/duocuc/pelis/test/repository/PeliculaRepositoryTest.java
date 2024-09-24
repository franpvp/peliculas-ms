package com.duocuc.pelis.test.repository;

import com.duocuc.pelis.entities.PeliculaEntity;
import com.duocuc.pelis.repository.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class PeliculaRepositoryTest {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Test
    public void guardarPeliculaTest() {
        PeliculaEntity resultado = peliculaRepository.save(PeliculaEntity.builder()
                .titulo("Titulo test")
                .anio(2010)
                .director("nombre director")
                .genero("genero")
                .sinopsis("sinopsis")
                .build());

        // Assert
        assertNotNull(resultado.getIdPelicula(), "El ID de la película no debe ser nulo");
        assertEquals("Titulo test", resultado.getTitulo(), "El título de la película no es correcto");
        assertEquals(2010, resultado.getAnio(), "El año de la película no es correcto");
        assertEquals("nombre director", resultado.getDirector(), "El director de la película no es correcto");
        assertEquals("genero", resultado.getGenero(), "El género de la película no es correcto");
        assertEquals("sinopsis", resultado.getSinopsis(), "La sinopsis de la película no es correcta");

    }

    @Test
    public void obtenerPeliculasTest() {

        List<PeliculaEntity> resultado = peliculaRepository.findAll();

        assertEquals(3, resultado.size(), "La lista debe contener dos películas");
        assertEquals("Inception", resultado.get(0).getTitulo());
        assertEquals("Parasite", resultado.get(1).getTitulo());

    }

}
