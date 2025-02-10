package com.pokemon_api.pokemon_api.dto;

import lombok.Data;

@Data
public class TypeDto {

    private Long id;

    private String name;

    private TypeAttackDto typeAttack;

}
