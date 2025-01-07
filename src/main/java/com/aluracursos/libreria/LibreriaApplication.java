package com.aluracursos.libreria;

import com.aluracursos.libreria.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//--llamamos a la clase principal con el metodo --//
		Principal principal=new Principal();
		principal.muestraElmenu();

	}




}
