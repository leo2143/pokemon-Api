package com.pokemon_api.pokemon_api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LevelEvolutionDto extends FormEvolutionDto {

    private int level;


}
