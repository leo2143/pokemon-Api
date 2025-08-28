package com.pokemon_api.pokemon_api.dto.update;

import com.pokemon_api.pokemon_api.dto.create.TypeEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.create.TypeStoneEvolutionCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TypeEvolutionUpdateDto extends TypeEvolutionCreateDto {

    @NotNull
    private Long id;

}
