package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.model.TypeEntity;
import com.pokemon_api.pokemon_api.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TypeMapperHelper {

    private final TypeRepository repository;

    @Named("idsToEntity")
    public Set<TypeEntity> idsToEntity(Set<Long> typeIds) {
        return (typeIds != null && !typeIds.isEmpty()) ?
                new HashSet<>(repository.findAllById(typeIds)) : null;
    }

}
