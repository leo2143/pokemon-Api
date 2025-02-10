package com.pokemon_api.pokemon_api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class MoLearnDto extends FormLearnDto {

    private String mo;


}
