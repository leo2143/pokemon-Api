package com.pokemon_api.pokemon_api.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PokemonDto {

    private Long id;

    private String name;

    private Double weight;

    private Double height;

    private Set<PokemonTypeDto> types = new HashSet<>();

    private PokemonDto evolution;
}
