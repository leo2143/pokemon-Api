package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.PokemonDto;
import com.pokemon_api.pokemon_api.dto.PokemonMinDto;
import com.pokemon_api.pokemon_api.dto.create.PokemonCreateDto;
import com.pokemon_api.pokemon_api.dto.update.PokemonUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.PokemonMapperHelper;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeMapperHelper;
import com.pokemon_api.pokemon_api.model.PokemonEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN, uses = {TypeMapper.class, TypeMapperHelper.class, PokemonMapperHelper.class})
public abstract class PokemonMapper extends DefaultMapper<PokemonDto, PokemonEntity, PokemonCreateDto, PokemonUpdateDto> {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "evolution", source = "evolutionId", qualifiedByName = "KeyToEntity")
    @Mapping(target = "types", source = "typeIds", qualifiedByName = "idsToEntity")
    @Mapping(target = "pokemonMovementForms",ignore = true)

    public abstract PokemonEntity fromCreateDtoToEntity(PokemonCreateDto createDto);

    public abstract PokemonDto ToDto(PokemonEntity entity);

    public abstract PokemonMinDto ToMinDto(PokemonEntity entity);

    public abstract List<PokemonDto> toListDto(List<PokemonEntity> entityList);

    @Mapping(target = "types", source = "typeIds", qualifiedByName = "idsToEntity")
    @Mapping(target = "evolution", source = "evolutionId", qualifiedByName = "KeyToEntity")
    @Mapping(target = "pokemonMovementForms",ignore = true)
    public abstract PokemonEntity merge(@MappingTarget PokemonEntity entity, PokemonUpdateDto update);


}
