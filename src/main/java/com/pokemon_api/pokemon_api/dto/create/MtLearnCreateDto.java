package com.pokemon_api.pokemon_api.dto.create;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MtLearnCreateDto extends FormLearnCreateDto {

    private String mt;

}
