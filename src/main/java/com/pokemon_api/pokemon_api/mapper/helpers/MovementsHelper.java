package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.model.MovementsEntity;
import com.pokemon_api.pokemon_api.repository.MovementsRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovementsHelper {

    private final MovementsRepository repository;

    @Named("KeyToMovementsEntity")
    public MovementsEntity KeyToMovementsEntity(Long id) {
        return (id != null) ? repository.findById(id).orElse(null) : null;
    }

}
