package com.aluracursos.libreria.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Libro {

    String titulo;
    List<DatosAutor> autor;
    List<String> idiomas;
    Double numeroDeDescargas;





    public Libro(DatosLibros datosLibros){
        this.titulo=datosLibros.titulo();
        this.autor=datosLibros.autor();
        this.idiomas=datosLibros.idiomas();

    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", idiomas=" + idiomas +
                ", numeroDeDescargas=" + numeroDeDescargas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<DatosAutor> getAutor() {
        return autor;
    }

    public void setAutor(List<DatosAutor> autor) {
        this.autor = autor;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
