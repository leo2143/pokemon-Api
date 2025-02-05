package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.model.PokemonEntity;
import com.pokemon_api.pokemon_api.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PokemonMapperHelper {

    private final PokemonRepository repository;

    @Named("KeyToEntity")
    public PokemonEntity keyToEntity(Long id) {
        return (id != null) ? repository.findById(id).orElse(null) : null;
    }

}
