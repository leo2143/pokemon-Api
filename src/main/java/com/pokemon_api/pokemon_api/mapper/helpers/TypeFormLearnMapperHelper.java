package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.model.TypeFormLearnEntity;
import com.pokemon_api.pokemon_api.repository.TypeFormLearnRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeFormLearnMapperHelper {

    private final TypeFormLearnRepository repository;

    @Named("KeyToEntity")
    public TypeFormLearnEntity keyToEntity(Long id) {
        return (id != null) ? repository.findById(id).orElse(null) : null;
    }

}
