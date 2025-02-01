package com.pokemon_api.pokemon_api.dto.update;

import com.pokemon_api.pokemon_api.dto.create.BaseStatisticsCreateDto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseStatisticsUpdateDto extends BaseStatisticsCreateDto {

    @NotNull
    private Long id;

}
