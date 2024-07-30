package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.create.PokemonCreateDto;
import com.pokemon_api.pokemon_api.dto.PokemonDto;
import com.pokemon_api.pokemon_api.dto.update.PokemonUpdateDto;
import com.pokemon_api.pokemon_api.model.PokemonEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.WARN
)
public abstract class PokemonMapper extends DefaultMapper<PokemonDto, PokemonEntity, PokemonCreateDto, PokemonUpdateDto> {

    @Mapping(target = "id", ignore = true)
    public abstract PokemonEntity fromCreateDtoToEntity(PokemonCreateDto createDto);

    public abstract PokemonDto ToDto(PokemonEntity createDto);

    public abstract List<PokemonDto> toListDto(List<PokemonEntity> entityList);

    public abstract PokemonEntity merge(@MappingTarget PokemonEntity entity, PokemonUpdateDto update);
}
