package com.pokemon_api.pokemon_api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class LevelLearnDto extends FormLearnDto {

    private String level;


}
