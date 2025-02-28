package com.pokemon_api.pokemon_api.dto.update;

import com.pokemon_api.pokemon_api.dto.create.SecondaryEffectsCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SecondaryEffectsUpdateDto extends SecondaryEffectsCreateDto {

    @NotNull
    private Long id;

}
