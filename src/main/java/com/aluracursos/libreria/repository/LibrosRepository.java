package com.aluracursos.libreria.repository;

import com.aluracursos.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libro,Long> {

    Optional<Libro> findByIdiomasContainsIgnoreCase(String idiomas);
}
