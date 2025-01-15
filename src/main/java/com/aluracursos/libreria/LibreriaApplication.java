package com.aluracursos.libreria;

import com.aluracursos.libreria.principal.Principal;
import com.aluracursos.libreria.repository.AutorRepository;
import com.aluracursos.libreria.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaApplication implements CommandLineRunner {
@Autowired
private LibrosRepository repository;
@Autowired
private AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//--llamamos a la clase principal con el metodo --//
		Principal principal=new Principal(repository, autorRepository);
		principal.muestraElmenu();

	}




}
