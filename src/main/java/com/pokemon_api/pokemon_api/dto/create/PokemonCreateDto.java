package com.pokemon_api.pokemon_api.dto.create;

import lombok.Data;

@Data
public class PokemonCreateDto {

    private String name;

    private Double weight;

    private Double height;
}
