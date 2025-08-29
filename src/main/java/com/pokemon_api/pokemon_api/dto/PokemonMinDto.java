package com.pokemon_api.pokemon_api.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class PokemonMinDto {

    private Long id;

    private String name;

    private Set<TypeDto> types = new HashSet<>();
}
