package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.dto.create.MovementsCreateDto;
import com.pokemon_api.pokemon_api.mapper.MovementsMapper;
import com.pokemon_api.pokemon_api.model.MovementsEntity;
import com.pokemon_api.pokemon_api.model.MovementsSecondaryEffectsEntity;
import com.pokemon_api.pokemon_api.model.SecondaryEffectsEntity;
import com.pokemon_api.pokemon_api.repository.MovementsSecondaryEffectsRepository;
import com.pokemon_api.pokemon_api.repository.SecondaryEffectsRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class MovementsSecondaryEffectsMapperHelper {

    private final MovementsMapper movementsMapper;

    private final SecondaryEffectsRepository secondaryEffectsRepository;

    private final MovementsSecondaryEffectsRepository movementsSecondaryEffectsRepository;

    public MovementsEntity createMovement(MovementsCreateDto createDto) {
        MovementsEntity movement = movementsMapper.fromCreateDtoToEntity(createDto);

        Set<MovementsSecondaryEffectsEntity> secondaryEffectsEntities = createDto.getSecondaryEffectsIds().stream()
                .map(id -> {
                    SecondaryEffectsEntity secondaryEffect = secondaryEffectsRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Secondary effect not found"));
                    return new MovementsSecondaryEffectsEntity(null, movement, secondaryEffect, createDto.getProbability());
                }).collect(Collectors.toSet());

        movement.setSecondaryEffects(secondaryEffectsEntities);
        MovementsEntity savedMovement = movementsRepository.save(movement);

        movementsSecondaryEffectsRepository.saveAll(secondaryEffectsEntities);
        return savedMovement;
    }


}
