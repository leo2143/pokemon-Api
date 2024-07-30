package com.pokemon_api.pokemon_api.dto.update;

import lombok.Data;

@Data
public class PokemonUpdateDto {

    private Long id;

    private String name;

    private Double weight;

    private Double height;
}
