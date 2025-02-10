package com.pokemon_api.pokemon_api.dto.create;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TypeAttackCreateDto {

    @NotNull
    private String name;

}
