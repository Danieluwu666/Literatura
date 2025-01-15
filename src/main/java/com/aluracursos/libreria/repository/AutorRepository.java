package com.aluracursos.libreria.repository;

import com.aluracursos.libreria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface AutorRepository extends JpaRepository<Autor, Long> {
        Autor findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :anoSeleccionado AND a.fechaDeMuerte >= :anoSeleccionado")
    List<Autor> buscarAutorVivoPorAno(int anoSeleccionado);


    }


