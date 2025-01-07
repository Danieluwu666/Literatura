package com.aluracursos.libreria.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Datos(    //Record para datos generales de la api
        @JsonAlias("results") List<DatosLibros> resultados
) {


}
