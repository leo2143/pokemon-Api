package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.model.TypeEvolutionEntity;
import com.pokemon_api.pokemon_api.repository.TypeEvolutionRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeEvolutionMapperHelper {

    private final TypeEvolutionRepository repository;

    @Named("KeyToTypeEvolutionEntity")
    public TypeEvolutionEntity KeyToTypeEvolutionEntity(String typeEvolution) {

        return repository.findByTypeEvolution(typeEvolution).orElse(null);
    }

}
