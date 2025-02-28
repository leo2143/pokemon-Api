package com.pokemon_api.pokemon_api.dto.update;

import com.pokemon_api.pokemon_api.dto.create.MovementsCreateDto;
import com.pokemon_api.pokemon_api.dto.create.SecondaryEffectsCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MovementsUpdateDto extends MovementsCreateDto {

    @NotNull
    private Long id;

}
