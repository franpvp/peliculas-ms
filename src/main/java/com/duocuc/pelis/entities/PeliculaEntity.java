package com.duocuc.pelis.entities;

import jakarta.persistence.*;
import lombok.Builder;


@Builder
@Entity
@Table(name = "PELICULA")
public class PeliculaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer idPelicula;

    @Column(name = "titulo", length = 100)
    private String titulo;

    @Column(name = "anio")
    private int anio;

    @Column(name = "director", length = 60)
    private String director;

    @Column(name = "genero", length = 60)
    private String genero;

    @Column(name = "sinopsis", length = 255)
    private String sinopsis;

    public PeliculaEntity() {
    }

    public PeliculaEntity(Integer idPelicula, String titulo, int anio, String director, String genero, String sinopsis) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
