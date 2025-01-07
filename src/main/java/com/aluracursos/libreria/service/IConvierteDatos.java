package com.aluracursos.libreria.service;

public interface IConvierteDatos {           //interfaz para convertir datos de json a una clase del programa

    <T> T obtenerDatos(String json, Class<T> clase);  //<T> T tipo de dato generico,
}
