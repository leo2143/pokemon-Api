package com.pokemon_api.pokemon_api.dto.update;

import com.pokemon_api.pokemon_api.dto.create.TypeCreateDto;
import com.pokemon_api.pokemon_api.dto.create.TypeFormLearnCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TypeFormLearnUpdateDto extends TypeFormLearnCreateDto {

    @NotNull
    private Long id;

}
