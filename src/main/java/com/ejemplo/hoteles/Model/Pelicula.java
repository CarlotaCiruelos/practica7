package com.ejemplo.hoteles.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pelicula {
	
	@JsonProperty("Title")
    private String title;
	
	@JsonProperty("Year")
    private String year;
	
	@JsonProperty("imdbID")
    private String imdbID;
	
	@JsonProperty("Type")
	private String type;
    
    @JsonProperty("Poster")
    private String poster;
}
