package com.aluracursos.desafio.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public record DatosLibros(
    @JsonAlias ("title") String titulo,
    @JsonAlias("authors") List <DatosAutor> autor,
    @JsonAlias("languages") List<String> idioma,
    @JsonAlias("download_count") Double numeroDeDescargas
) {


}
