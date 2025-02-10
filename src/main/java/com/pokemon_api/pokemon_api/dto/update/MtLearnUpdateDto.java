package com.pokemon_api.pokemon_api.dto.update;

import com.pokemon_api.pokemon_api.dto.create.MoLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.create.MtLearnCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MtLearnUpdateDto extends MtLearnCreateDto {

    @NotNull
    private Long id;

}
