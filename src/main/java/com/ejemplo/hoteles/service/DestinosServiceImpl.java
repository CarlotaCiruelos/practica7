package com.ejemplo.hoteles.service;


import com.ejemplo.hoteles.Model.Pelicula;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class DestinosServiceImpl implements DestinosService{

    @Override
    public List<String> getDestinations() {
        return List.of(
                "Madrid",
                "Barcelona",
                "Santander");
    }

    @Override
    public  ArrayList<Pelicula>  getPeliculas() throws JsonProcessingException {
        
    	RestTemplate restTemplate = new RestTemplate();
    	ArrayList<Pelicula> lista= new ArrayList<Pelicula>();
        
        String fooResourceUrl
                = "https://www.omdbapi.com/?apikey=cc1014ca&s=Star";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        Iterator<JsonNode> items= root.get("Search").elements();
        
        while (items.hasNext()) {
			JsonNode item=items.next();
			lista.add(mapper.treeToValue(item,Pelicula.class));
		}
        
       
    
    

    return lista;
    }

    @Override
    public ArrayList<Pelicula> getPeliculasByName(String name) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Pelicula> lista= new ArrayList<Pelicula>();

        String fooResourceUrl
                = "https://www.omdbapi.com/?apikey=cc1014ca&s="+name;

        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        try {
            Iterator<JsonNode> items = root.get("Search").elements();

            while (items.hasNext()) {
                JsonNode item = items.next();
                lista.add(mapper.treeToValue(item, Pelicula.class));
            }
        }

        catch (NullPointerException e){
            log.info("Error no existe esa pelicula");

            }

            return lista;
        }

    @Override
    public ArrayList<Pelicula> getPeliculaByYear(String name, String year) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<Pelicula> lista= new ArrayList<Pelicula>();

        String fooResourceUrl
                = "https://www.omdbapi.com/?apikey=cc1014ca&s="+name+"&y="+year;

        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        try {
            Iterator<JsonNode> items = root.get("Search").elements();

            while (items.hasNext()) {
                JsonNode item = items.next();
                lista.add(mapper.treeToValue(item, Pelicula.class));
            }
        }

        catch (NullPointerException e){
            log.info("Error no existe esa pelicula");

        }

        return lista;
    }

}




