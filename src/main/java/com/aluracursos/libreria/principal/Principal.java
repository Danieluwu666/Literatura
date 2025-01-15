package com.aluracursos.libreria.principal;


import com.aluracursos.libreria.model.Autor;
import com.aluracursos.libreria.model.Datos;
import com.aluracursos.libreria.model.DatosLibros;
import com.aluracursos.libreria.model.Libro;
import com.aluracursos.libreria.repository.AutorRepository;
import com.aluracursos.libreria.repository.LibrosRepository;
import com.aluracursos.libreria.service.ConsumoAPI;
import com.aluracursos.libreria.service.ConvierteDatos;

import java.util.*;

public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private List<DatosLibros> datosLibros = new ArrayList<>();

    private LibrosRepository repositorio;
    private AutorRepository autorRepository;


    public Principal(LibrosRepository repository, AutorRepository autorRepository) {
        this.repositorio = repository;
        this.autorRepository=autorRepository;
    }

    public void muestraElmenu() {


        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    Elija la opcion a través de su número:
                    1 - Buscar libro por título.
                    2 - Listar libros registrados.
                    3 - Listar autores registrados. 
                    4 - Listar autores vivos en un año determinado. 
                    5 - Listar libros por idiomas. 
                    0 - salir 
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();


            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    mostrarAutores();
                    break;
                case 4:
                    mostrarAutoresVivos();
                    break;
                case 5:

                mostrarLibroPorIdioma();
                break;
                case 0:
                    //System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    //System.out.println("Opcion no valida");
            }


        }


    }

    private DatosLibros getDatosLibro() {
        System.out.println("Ingrese el nombre del libro que desea buscar: ");
        var tituloLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("Libro encontrado ");
            DatosLibros dato = libroBuscado.get();
            return dato;
        } else {
            System.out.println("Libro no encontrado");
            return null;
        }

    }

    private void buscarLibroPorTitulo() {
        DatosLibros datos = getDatosLibro();
        if (datos != null) {
            Libro libro = new Libro(datos, autorRepository);
            repositorio.save(libro);
        }
        System.out.println(datos);

    }

    private void mostrarLibros() {
        List<Libro> libros = repositorio.findAll();
        libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .forEach(System.out::println);


    }

    private void mostrarAutores(){
        List<Autor> autores = autorRepository.findAll();

        autores.stream()
                .sorted(Comparator.comparing(Autor::getNombre))
                .forEach(a -> System.out.println("Nombre: " + a.getNombre()
                        + ", Fecha de nacimiento: " + a.getFechaDeNacimiento()
                        + ", Fecha de fallecimiento: " + a.getFechaDeMuerte()));
    }

    private void mostrarAutoresVivos() {
        int anoSeleccionado;

            System.out.println("Escribe el año (AAAA) que estás buscando: ");
            while (!teclado.hasNextInt()) {
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
                teclado.next();
            }
            anoSeleccionado = teclado.nextInt();
            teclado.nextLine();

            if (String.valueOf(anoSeleccionado).length() != 4) {
                System.out.println("El año debe tener cuatro dígitos. Intenta de nuevo.");
            }
         while (String.valueOf(anoSeleccionado).length() != 4);

        System.out.println("Año seleccionado: " + anoSeleccionado);
        List<Autor> filtroAutores = autorRepository.buscarAutorVivoPorAno(anoSeleccionado);
        filtroAutores.forEach(a ->
                System.out.println("Nombre: " + a.getNombre()
                        + ", Año de Nacimiento: " + a.getFechaDeNacimiento()
                        + ", Año de Fallecimiento: " + a.getFechaDeMuerte()));
    }




    private void mostrarLibroPorIdioma(){
        var opcion = """
                    Eliga el idioma de los libros que desea listar:
                    es - español 
                    en - inglés 
                    fr - francés 
                    pt - portugues 
                    """;
        System.out.println(opcion);
        var idiomas=teclado.nextLine();
       Optional<Libro> libroBuscado=repositorio.findByIdiomasContainsIgnoreCase(idiomas);

        if(libroBuscado.isPresent()){
            System.out.println("los libros en: "+idiomas+" son"+libroBuscado.get());
        }else{
            System.out.println("no hay libros registrados en "+ idiomas);
        }
    }


}
