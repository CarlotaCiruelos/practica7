package com.ejemplo.hoteles.controller;

import com.ejemplo.hoteles.Model.Pelicula;
import com.ejemplo.hoteles.service.DestinosService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class DestinosController {

    @Autowired
    private DestinosService destinosService;

    @GetMapping("/peli/")
    public @ResponseBody
    ResponseEntity<List<Pelicula>> getPeliculas() throws JsonProcessingException {
        log.info("Ejecuntando la operacion de filtrado por nombre");
        return ResponseEntity.ok().body(destinosService.getPeliculas());
    }


    @GetMapping("/peliculas/{name}")
    public @ResponseBody
    ResponseEntity <List<Pelicula>> getPeliculasByName(@PathVariable("name") String name) throws JsonProcessingException {
        log.info(name);
        log.info("Ejecuntando la operacion de filtrado por nombre");
        return ResponseEntity.ok().body(destinosService.getPeliculasByName(name));

    }
    @GetMapping("/peliculas/{name}/{year}")
    public @ResponseBody
    ResponseEntity <List<Pelicula>> getPeliculasByYear(@PathVariable("name") String name, @PathVariable("year") String year) throws JsonProcessingException {
        log.info(year);
        log.info(name);
        log.info("Ejecuntando la operacion de filtrado por fecha");
        return ResponseEntity.ok().body(destinosService.getPeliculaByYear(name,year));

    }
}
