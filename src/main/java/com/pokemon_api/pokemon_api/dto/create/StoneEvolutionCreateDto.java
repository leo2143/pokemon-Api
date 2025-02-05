package com.pokemon_api.pokemon_api.dto.create;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StoneEvolutionCreateDto extends FormEvolutionCreateDto {

    private Long typeStoneId;

}
