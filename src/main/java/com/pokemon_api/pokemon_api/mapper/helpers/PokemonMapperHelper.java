package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.dto.create.BaseStatisticsCreateDto;
import com.pokemon_api.pokemon_api.mapper.BaseStatisticsMapper;
import com.pokemon_api.pokemon_api.model.BaseStatisticsEntity;
import com.pokemon_api.pokemon_api.model.PokemonEntity;
import com.pokemon_api.pokemon_api.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PokemonMapperHelper {

    private final PokemonRepository repository;
    private final BaseStatisticsMapper baseStatisticsMapper;

    @Named("KeyToEntity")
    public PokemonEntity keyToEntity(Long id) {
        return (id != null) ? repository.findById(id).orElse(null) : null;
    }

    @Named("mapBaseStatistics")
    public BaseStatisticsEntity mapBaseStatistics(BaseStatisticsCreateDto createDto) {
        if (createDto == null) {
            return null;
        }
        // Aquí mapeas el BaseStatisticsCreateDto a BaseStatisticsEntity
        BaseStatisticsEntity baseStatisticsEntity = baseStatisticsMapper.fromCreateDtoToEntity(createDto);
        return baseStatisticsEntity;
    }

}
