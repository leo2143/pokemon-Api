package com.pokemon_api.pokemon_api.dto.create;

import com.pokemon_api.pokemon_api.model.MovementsEntity;
import com.pokemon_api.pokemon_api.model.SecondaryEffectsEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Set;

@Data
public class MovementsSecondaryEffectsCreateDto {

    private Long movementsId;

    private Long secondaryEffectsId;

    private int probability;

}
