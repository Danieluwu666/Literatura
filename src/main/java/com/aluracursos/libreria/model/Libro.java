package com.aluracursos.libreria.model;

import com.aluracursos.libreria.repository.AutorRepository;
import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor")
    private Autor autor;
    private String idiomas; // Almacenaremos los idiomas separados por comas.


    private Double numeroDeDescargas;



    public Libro() {
    }

    public Libro(DatosLibros datosLibros, AutorRepository autorRepository) {
        this.titulo = datosLibros.titulo();
        if (!datosLibros.autor().isEmpty()) {
            DatosAutor datosAutor = datosLibros.autor().get(0); // Tomamos el primer autor
            Autor autor = autorRepository.findByNombre(datosAutor.nombre());
            if (autor == null) { // Si el autor no existe, lo creamos
                autor = new Autor(datosAutor);
                autorRepository.save(autor);
            }
            this.autor = autor;
        }
        this.idiomas = datosLibros.idiomas().get(0);
        this.numeroDeDescargas = OptionalDouble.of(datosLibros.numeroDeDescargas()).orElse(0);
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autores='" + autor + '\'' +
                ", idiomas='" + idiomas + '\'' +
                ", numeroDeDescargas=" + numeroDeDescargas +
                '}';
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
