package com.pokemon_api.pokemon_api.dto.create;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LevelLearnCreateDto extends FormLearnCreateDto {

    private int level;

}
