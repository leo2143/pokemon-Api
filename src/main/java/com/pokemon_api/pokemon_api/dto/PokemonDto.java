package com.pokemon_api.pokemon_api.dto;

import com.pokemon_api.pokemon_api.model.FormEvolutionEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class PokemonDto {

    private Long id;

    private String name;

    private Double weight;

    private Double height;

    private Set<TypeDto> types = new HashSet<>();

    private PokemonMinDto evolution;

    private List<FormEvolutionDto> formEvolutions = new ArrayList<>();

    private BaseStatisticsDto baseStatistics;
}
