package com.duocuc.pelis.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PeliculaDTO {

    @NotNull(message = "El campo idPelicula no puede estar vacío")
    @Positive(message = "El campo idPelicula debe ser un número positivo")
    private Integer idPelicula;

    @NotNull(message = "El campo título no puede estar vacío")
    @Size(min = 5, max = 50, message = "El campo nombre debe tener entre 5 y 50 caracteres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El campo titulo solo puede contener letras")
    private String titulo;

    @NotNull(message = "El campo anio no puede estar vacío")
    @Positive(message = "El campo anio debe ser un número positivo")
    @Size(min = 4, max = 4, message = "El campo anio debe tener entre 4 caracteres")
    private int anio;

    @NotNull(message = "El campo director no puede estar vacío")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El campo titulo solo puede contener letras")
    private String director;

    @NotNull(message = "El campo genero no puede estar vacío")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El campo titulo solo puede contener letras")
    private String genero;

    @NotNull(message = "El campo sinopsis no puede estar vacío")
    private String sinopsis;
}
