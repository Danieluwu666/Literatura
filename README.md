Libreria API Challenge

Descripción

Este proyecto es una aplicación de consola desarrollada en Java utilizando Spring Boot, que interactúa con la API de GutenDex para buscar y registrar información sobre libros y autores. Los datos obtenidos se almacenan en una base de datos PostgreSQL.

Tecnologías Utilizadas

Java 17

Spring Boot (Data JPA, Web)

PostgreSQL

Jakarta Persistence API (JPA)

Jackson (para manejo de JSON)

Maven

Configuración del Entorno

Asegúrese de tener las siguientes herramientas instaladas:

Java 17 o superior

PostgreSQL

Maven

Configure la base de datos:

Cree una base de datos llamada libreriachallenge en PostgreSQL.

Configure las credenciales de la base de datos en el archivo application.properties:

spring.datasource.url=jdbc:postgresql://${DB_HOST}/libreriachallenge
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver
hibernate.dialect=org.hibernate.dialect.HSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.format-sql=true

Compile y ejecute el proyecto:

mvn clean install
mvn spring-boot:run

Estructura del Proyecto

Modelos:

Autor: Representa a un autor con sus datos básicos y una lista de libros asociados.

Libro: Representa un libro, incluyendo su autor, idiomas y número de descargas.

Datos, DatosAutor, DatosLibros: Registros para manejar los datos provenientes de la API.

Repositorios:

AutorRepository: Interfaz para operaciones CRUD con la entidad Autor.

LibrosRepository: Interfaz para operaciones CRUD con la entidad Libro.

Servicios:

ConsumoAPI: Clase para realizar peticiones HTTP a la API de GutenDex.

ConvierteDatos: Clase para convertir datos JSON en objetos Java.

Principal:
Clase principal que muestra el menú interactivo y permite realizar las siguientes acciones:

Buscar un libro por título.

Listar libros registrados.

Listar autores registrados.

Listar libros por idioma.

Funcionalidades

Menú de Usuario

Buscar libro por título: Permite buscar un libro en la API por su título y guardarlo en la base de datos.

Listar libros registrados: Muestra los libros almacenados en la base de datos.

Listar autores registrados: Muestra los autores almacenados en la base de datos.

Listar libros por idiomas: Filtra libros registrados según el idioma especificado.

Almacenamiento

Los datos de los libros y autores se almacenan en las tablas libros y autor en PostgreSQL.
