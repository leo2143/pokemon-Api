package com.pokemon_api.pokemon_api.dto;

import lombok.Data;

@Data
public class PokemonDto {

    private Long id;

    private String name;

    private Double weight;

    private Double height;
}
