package com.pokemon_api.pokemon_api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MtLearnDto extends FormLearnDto {

    private String mt;


}
