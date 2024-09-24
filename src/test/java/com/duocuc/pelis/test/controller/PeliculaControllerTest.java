package com.duocuc.pelis.test.controller;

import com.duocuc.pelis.controller.PeliculaController;
import com.duocuc.pelis.entities.PeliculaEntity;
import com.duocuc.pelis.service.PeliculaServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PeliculaServiceImpl peliculaServiceMock;

    @InjectMocks
    private PeliculaController peliculaController;

    private ObjectMapper objectMapper;

    private PeliculaEntity pelicula;

    @BeforeEach
    public void setUp() {
        // Inicializa los mocks antes de cada prueba
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();

        pelicula = new PeliculaEntity();
        pelicula.setIdPelicula(1);
        pelicula.setTitulo("titulo test");
        pelicula.setAnio(2022);
        pelicula.setDirector("director test");
        pelicula.setGenero("genero test");
        pelicula.setSinopsis("sinopsis test");
    }

    @Test
    public void crearPeliculaTest() throws Exception {

        when(peliculaServiceMock.guardarPelicula(any(PeliculaEntity.class))).thenReturn(pelicula);

        mockMvc.perform(post("/crear-pelicula")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pelicula)))
                .andExpect(status().isOk());
    }

    @Test
    public void getPeliculasTest() throws Exception {

        when(peliculaServiceMock.getPeliculas()).thenReturn(Arrays.asList(pelicula));

        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("titulo test"));

    }

    @Test
    public void getPeliculaByIdTest() throws Exception {
        when(peliculaServiceMock.getPeliculaById(anyInt())).thenReturn(pelicula);

        mockMvc.perform(get("/peliculas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("titulo test"));
    }


}
