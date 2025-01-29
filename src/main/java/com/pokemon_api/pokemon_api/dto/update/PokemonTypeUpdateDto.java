package com.pokemon_api.pokemon_api.dto.update;

import com.pokemon_api.pokemon_api.dto.create.PokemonTypeCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PokemonTypeUpdateDto extends PokemonTypeCreateDto {

    @NotNull
    private Long id;

}
