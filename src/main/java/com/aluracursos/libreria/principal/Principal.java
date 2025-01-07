package com.aluracursos.libreria.principal;

import com.aluracursos.libreria.model.Datos;
import com.aluracursos.libreria.model.DatosLibros;
import com.aluracursos.libreria.service.ConsumoAPI;
import com.aluracursos.libreria.service.ConvierteDatos;

import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);

    public void muestraElmenu() {




        var opcion =-1;
        while (opcion!=0){
            var menu= """
                 Elija la opcion a través de su número:
                 1 - Buscar libro por título.
                 2 - Listar libros registrados.
                 3 - Listar autores registrados. 
                 4 - Listar autores vivos en un año determinado. 
                 5 - Listar libros por idiomas. 
                 0 - salir 
                 """;
            System.out.println(menu);
            opcion= teclado.nextInt();
            teclado.nextLine();


            switch (opcion){
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    //mostrarLibros();
                    break;
                case 3:
                    //mostrarAutores();
                    break;
                case 4:
                    //mostrarAutoresVivos();
                    break;
                case 5:
                    break;
                    //mostrarLibroPorIdioma();
                case 0:
                    //System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    //System.out.println("Opcion no valida");
            }


        }


    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        var tituloLibro= teclado.nextLine();
         var json= consumoAPI.obtenerDatos(URL_BASE+"?search="+tituloLibro.replace(" ","+"));
        var datosBusqueda=conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado=datosBusqueda.resultados().stream()
                .filter(l->l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if(libroBuscado.isPresent()){
            System.out.println("Libro encontrado ");
            System.out.println(libroBuscado.get());
        }else {
            System.out.println("Libro no encontrado");
        }

    }
}
