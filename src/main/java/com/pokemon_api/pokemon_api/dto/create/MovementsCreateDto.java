package com.pokemon_api.pokemon_api.dto.create;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Set;

@Data
public class MovementsCreateDto {

    private String name;

    private Long strenght;

    @Column(name = "precision_mov")
    private Long precisionMov;

    private String description;

    private Set<Long> secondaryEffectsIds;

    private int pp;

    private int priority;

    private int probability;

}
