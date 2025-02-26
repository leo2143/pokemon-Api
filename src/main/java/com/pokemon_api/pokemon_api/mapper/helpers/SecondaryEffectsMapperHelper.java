package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.model.SecondaryEffectsEntity;
import com.pokemon_api.pokemon_api.repository.SecondaryEffectsRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SecondaryEffectsMapperHelper {

    private final SecondaryEffectsRepository repository;

    @Named("idsToEntity")
    public Set<SecondaryEffectsEntity> idsToEntity(Set<Long> typeIds) {
        return (typeIds != null && !typeIds.isEmpty()) ?
                new HashSet<>(repository.findAllById(typeIds)) : null;
    }

}
