package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.model.TypeStoneEvolutionEntity;
import com.pokemon_api.pokemon_api.repository.TypeStoneEvolutionRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeStoneEvolutionMapperHelper {

    private final TypeStoneEvolutionRepository repository;

    @Named("KeyToTypeStoneEntity")
    public TypeStoneEvolutionEntity KeyToTypeStoneEntity(Long id) {
        return (id != null) ? repository.findById(id).orElse(null) : null;
    }

}
