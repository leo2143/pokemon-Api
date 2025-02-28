package com.pokemon_api.pokemon_api.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Set;

@Data
public class MovementsDto {

    private Long id;

    private String name;

    private Long strenght;

    private Long precisionMov;

    private String description;

    private int pp;

    private int priority;


}
