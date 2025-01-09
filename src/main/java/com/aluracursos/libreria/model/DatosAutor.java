
package com.aluracursos.libreria.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(    //Record para los datos de los autores
        @JsonAlias("name") String nombre,
        @JsonAlias("birth_year") String fechaDeNacimiento

) {
}
