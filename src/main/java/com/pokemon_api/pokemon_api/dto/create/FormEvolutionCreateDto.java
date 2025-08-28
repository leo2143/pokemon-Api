package com.pokemon_api.pokemon_api.dto.create;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pokemon_api.pokemon_api.model.TypeEvolutionEntity;
import lombok.Data;

@Data
public class FormEvolutionCreateDto {

    private String typeEvolutionName;

}
