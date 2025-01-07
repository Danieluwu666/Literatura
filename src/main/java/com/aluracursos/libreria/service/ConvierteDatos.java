package com.aluracursos.libreria.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements  IConvierteDatos {  //implementa de la interfaz convertir datos
    private ObjectMapper objectMapper=new ObjectMapper();  //mapper para convertir


    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {       //si implementamos de la interfaz debo implementar el metodo de iConvierte datos
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
