package com.pokemon_api.pokemon_api.dto.update;

import com.pokemon_api.pokemon_api.dto.create.TypeCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TypeUpdateDto extends TypeCreateDto {

    @NotNull
    private Long id;

}
