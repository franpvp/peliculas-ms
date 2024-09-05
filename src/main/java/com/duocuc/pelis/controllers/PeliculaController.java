package com.duocuc.pelis.controllers;

import com.duocuc.pelis.entities.Pelicula;
import com.duocuc.pelis.services.PeliculaService;
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
    public void crearPelicula(@RequestBody Pelicula pelicula) {
        peliculaService.guardarPelicula(pelicula);
    }

    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculaService.getPeliculas();
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula getPeliculaById(@PathVariable("id") int id) {
        return peliculaService.getPeliculaById(id);
    }

    @PutMapping("/modificar-pelicula/{id}")
    public ResponseEntity<Pelicula> modificarPelicula(
            @PathVariable("id") int id,
            @RequestBody Pelicula peliculaUpdate
    ) {
        Optional<Pelicula> peliculaActualizada = peliculaService.modificarPelicula(id, peliculaUpdate);
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
