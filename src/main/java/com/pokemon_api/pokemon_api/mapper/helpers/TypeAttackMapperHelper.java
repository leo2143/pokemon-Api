package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.model.TypeAttackEntity;
import com.pokemon_api.pokemon_api.repository.TypeAttackRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TypeAttackMapperHelper {

    private final TypeAttackRepository repository;

    @Named("KeyToEntity")
    public TypeAttackEntity keyToEntity(Long id) {
        return (id != null) ? repository.findById(id).orElse(null) : null;
    }

}
