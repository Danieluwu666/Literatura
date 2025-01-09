package com.aluracursos.libreria.repository;

import com.aluracursos.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libro,Long> {


}
