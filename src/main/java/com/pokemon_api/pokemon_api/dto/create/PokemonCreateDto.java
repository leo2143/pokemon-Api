package com.pokemon_api.pokemon_api.dto.create;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class PokemonCreateDto {

    private String name;

    private Double weight;

    private Double height;

    private Set<Long> typeIds = new HashSet<>();

    private Long evolutionId;

    private Set<Long> formEvolutionIds;

    private BaseStatisticsCreateDto baseStatistics;
}
