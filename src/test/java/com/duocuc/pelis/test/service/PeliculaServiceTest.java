package com.duocuc.pelis.test.service;
import com.duocuc.pelis.entities.PeliculaEntity;
import com.duocuc.pelis.repository.PeliculaRepository;
import com.duocuc.pelis.service.PeliculaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.when;

@SpringBootTest
public class PeliculaServiceTest {

    @Mock
    private PeliculaRepository peliculaRepository;

    @InjectMocks
    private PeliculaServiceImpl peliculaServiceImpl;

    @BeforeEach
    public void setUp() {
        // Inicializa los mocks antes de cada prueba
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void guardarPeliculaTest() {
        // Se crea un objeto PeliculaEntity
        PeliculaEntity peliculaEntity = PeliculaEntity.builder()
                .titulo("nombre pelicula")
                .anio(2023)
                .build();

        when(peliculaRepository.save(any(PeliculaEntity.class))).thenReturn(peliculaEntity);

        PeliculaEntity resultado = peliculaServiceImpl.guardarPelicula(peliculaEntity);

        assertNotNull(resultado, "La lista de películas no debe ser nula");
        assertEquals("nombre pelicula", resultado.getTitulo(), "El título debe ser 'nombre pelicula'");
        assertEquals(2023, resultado.getAnio(), "El año debe ser 2023");

        verify(peliculaRepository, times(1)).save(peliculaEntity);

    }

    @Test
    public void getPeliculasTest() {
        // Creación de objetos tipo PeliculaEntity
        PeliculaEntity peliculaEntity1 = PeliculaEntity.builder()
                .titulo("titulo")
                .anio(2023)
                .build();
        PeliculaEntity peliculaEntity2 = PeliculaEntity.builder()
                .titulo("titulo 2")
                .anio(2024)
                .build();
        // Almacenamos las peliculas en una lista
        List<PeliculaEntity> listaPeliculas = Arrays.asList(peliculaEntity1, peliculaEntity2);

        // Utilizamos when para llamar al método findAll() del repositorio y este debe retornar una lista de peliculas
        when(peliculaRepository.findAll()).thenReturn(listaPeliculas);

        // Llamar al método que se desea probar
        List<PeliculaEntity> resultado = peliculaServiceImpl.getPeliculas();

        // Verifica el resultado
        assertNotNull(resultado, "La lista de películas no debe ser nula");
        assertEquals(2, resultado.size(), "La lista debe contener dos películas");
        assertEquals("titulo", resultado.get(0).getTitulo(), "La primera película debe ser 'titulo'");
        assertEquals("titulo 2", resultado.get(1).getTitulo(), "La segunda película debe ser 'titulo 2'");

        // Verifica que el método findAll() fue llamado una vez
        verify(peliculaRepository, times(1)).findAll();
    }

    @Test
    public void getPeliculaByIdTest() {

        PeliculaEntity peliculaEntity = PeliculaEntity.builder()
                .idPelicula(1)
                .titulo("titulo")
                .anio(2023)
                .build();

        when(peliculaRepository.findById(1)).thenReturn(Optional.of(peliculaEntity));

        // Se llama el método a probar mediante el servicio
        PeliculaEntity resultado = peliculaServiceImpl.getPeliculaById(1);

        assertNotNull(resultado, "La pelicula no debe ser nula");
        assertEquals(1, resultado.getIdPelicula(), "El id de la pelicula debe ser 1");
        assertEquals("titulo", resultado.getTitulo(), "El titulo de la pelicula debe ser 'titulo' ");

        // Verifica que el método findById() fue llamado con el ID correcto
        verify(peliculaRepository, times(1)).findById(1);

    }

    @Test
    public void modificarPeliculaExitosoTest() {

        PeliculaEntity peliculaEntityOriginal = PeliculaEntity.builder()
                .idPelicula(1)
                .titulo("titulo")
                .anio(2023)
                .build();

        PeliculaEntity peliculaEntityActualizada = PeliculaEntity.builder()
                .titulo("titulo actualizado")
                .anio(2024)
                .build();

        when(peliculaRepository.findById(anyInt())).thenReturn(Optional.of(peliculaEntityOriginal));
        when(peliculaRepository.save(any(PeliculaEntity.class))).thenReturn(peliculaEntityOriginal);

        Optional<PeliculaEntity> resultado = peliculaServiceImpl.modificarPelicula(1, peliculaEntityActualizada);

        assertTrue(resultado.isPresent());
        assertEquals("titulo actualizado", resultado.get().getTitulo());
        assertEquals(2024, resultado.get().getAnio());
    }

    @Test
    public void modificarPeliculaNoExitosoTest() {

        PeliculaEntity peliculaEntityActualizada = PeliculaEntity.builder()
                .titulo("titulo actualizado")
                .anio(2024)
                .build();
        // Simular comportamiento del repositorio: película no encontrada
        when(peliculaRepository.findById(anyInt())).thenReturn(Optional.empty());

        Optional<PeliculaEntity> resultado = peliculaServiceImpl.modificarPelicula(1, peliculaEntityActualizada);

        assertTrue(resultado.isEmpty());
    }

    @Test
    public void eliminarPeliculaTest() {

        doNothing().when(peliculaRepository).deleteById(anyInt());

        peliculaServiceImpl.eliminarPelicula(anyInt());

        verify(peliculaRepository, times(1)).deleteById(anyInt());
    }

    @Test
    public void eliminarAllTest() {
        doNothing().when(peliculaRepository).deleteAll();

        peliculaServiceImpl.eliminarAll();

        verify(peliculaRepository, times(1)).deleteAll();
    }


}
