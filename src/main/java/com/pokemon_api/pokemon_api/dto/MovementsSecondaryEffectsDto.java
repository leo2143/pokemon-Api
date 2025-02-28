package com.pokemon_api.pokemon_api.dto;

import lombok.Data;


@Data
public class MovementsSecondaryEffectsDto {

    private Long id;

    private MovementsDto movements;

    private SecondaryEffectsDto secondaryEffects;

    private int probability;
}
