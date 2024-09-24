package com.duocuc.pelis.controller;

import com.duocuc.pelis.entities.PeliculaEntity;
import com.duocuc.pelis.service.PeliculaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping("/crear-pelicula")
    public void crearPelicula(@RequestBody PeliculaEntity peliculaEntity) {
        peliculaService.guardarPelicula(peliculaEntity);
    }

    @GetMapping("/peliculas")
    public List<PeliculaEntity> getPeliculas() {
        return peliculaService.getPeliculas();
    }

    @GetMapping("/peliculas/{id}")
    public PeliculaEntity getPeliculaById(@PathVariable("id") int id) {
        return peliculaService.getPeliculaById(id);
    }

    @PutMapping("/modificar-pelicula/{id}")
    public ResponseEntity<PeliculaEntity> modificarPelicula(
            @PathVariable("id") int id,
            @RequestBody PeliculaEntity peliculaEntityUpdate
    ) {
        Optional<PeliculaEntity> peliculaActualizada = peliculaService.modificarPelicula(id, peliculaEntityUpdate);
        if (peliculaActualizada.isPresent()) {
            return ResponseEntity.ok(peliculaActualizada.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/borrar-pelicula/{id}")
    public String eliminarPelicula(@PathVariable int id) {
        peliculaService.eliminarPelicula(id);
        return "Pelicula Eliminada";
    }

    @DeleteMapping("eliminar-all")
    public String eliminarAll(){
        peliculaService.eliminarAll();
        return "Se han eliminado todas las peliculas";
    }
}
