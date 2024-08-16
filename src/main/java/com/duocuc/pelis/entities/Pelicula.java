package com.duocuc.pelis.entities;

public class Pelicula {

    private int id;
    private String titulo;
    private int anio;
    private String director;
    private String genero;
    private String sinopsis;

    public Pelicula(String titulo, int id, int anio, String director, String genero, String sinopsis) {
        this.titulo = titulo;
        this.id = id;
        this.anio = anio;
        this.director = director;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", director='" + director + '\'' +
                ", genero='" + genero + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                '}';
    }

    // a.	GET /peliculas/{id}: Para obtener información detallada sobre una película en función de su ID.
    // b.	GET/películas: Para obtener toda la información detallada sobre las películas que se encuentren registradas.
}
