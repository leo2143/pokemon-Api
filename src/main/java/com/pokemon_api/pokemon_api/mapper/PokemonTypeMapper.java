package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.PokemonTypeDto;
import com.pokemon_api.pokemon_api.dto.create.PokemonTypeCreateDto;
import com.pokemon_api.pokemon_api.dto.update.PokemonTypeUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.PokemonTypeMapperHelper;
import com.pokemon_api.pokemon_api.model.PokemonTypeEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = { PokemonTypeMapperHelper.class})
public abstract class PokemonTypeMapper extends DefaultMapper<PokemonTypeDto, PokemonTypeEntity, PokemonTypeCreateDto, PokemonTypeUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemons", ignore = true)
    public abstract PokemonTypeEntity fromCreateDtoToEntity(PokemonTypeCreateDto createDto);

    public abstract PokemonTypeDto ToDto(PokemonTypeEntity entity);

    public abstract List<PokemonTypeDto> toListDto(List<PokemonTypeEntity> entityList);

    @Mapping(target = "pokemons", ignore = true)
    public abstract PokemonTypeEntity merge(@MappingTarget PokemonTypeEntity entity, PokemonTypeUpdateDto update);


}
