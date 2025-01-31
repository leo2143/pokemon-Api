package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.model.PokemonTypeEntity;
import com.pokemon_api.pokemon_api.repository.PokemonTypeRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PokemonTypeMapperHelper {

    private final PokemonTypeRepository repository;

    @Named("idsToEntity")
    public Set<PokemonTypeEntity> idsToEntity(Set<Long> typeIds) {
        return (typeIds != null && !typeIds.isEmpty()) ?
                new HashSet<>(repository.findAllById(typeIds)) : null;
    }

}
