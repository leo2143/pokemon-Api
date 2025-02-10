package com.pokemon_api.pokemon_api.dto.update;

import com.pokemon_api.pokemon_api.dto.create.TypeStoneEvolutionCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TypeStoneEvolutionUpdateDto extends TypeStoneEvolutionCreateDto {

    @NotNull
    private Long id;

}
