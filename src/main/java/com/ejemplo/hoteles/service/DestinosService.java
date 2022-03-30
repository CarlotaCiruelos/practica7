package com.ejemplo.hoteles.service;

import com.ejemplo.hoteles.Model.Pelicula;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface DestinosService {
    List<String> getDestinations();
    ArrayList<Pelicula>  getPeliculas() throws JsonProcessingException;
    ArrayList<Pelicula> getPeliculasByName(String name) throws JsonProcessingException;
    ArrayList<Pelicula> getPeliculaByYear(String name, String year) throws JsonProcessingException;
}

