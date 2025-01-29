package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.PokemonTypeDto;
import com.pokemon_api.pokemon_api.dto.create.PokemonTypeCreateDto;
import com.pokemon_api.pokemon_api.dto.update.PokemonTypeUpdateDto;
import com.pokemon_api.pokemon_api.model.PokemonEntity;
import com.pokemon_api.pokemon_api.model.PokemonTypeEntity;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.WARN
)
public abstract class PokemonTypeMapper extends DefaultMapper<PokemonTypeDto, PokemonTypeEntity, PokemonTypeCreateDto, PokemonTypeUpdateDto> {

    @Mapping(target = "id", ignore = true)
    public abstract PokemonTypeEntity fromCreateDtoToEntity(PokemonTypeCreateDto createDto);

    public abstract PokemonTypeDto ToDto(PokemonTypeEntity createDto);

    public abstract List<PokemonTypeDto> toListDto(List<PokemonTypeEntity> entityList);

    public abstract PokemonTypeEntity merge(@MappingTarget PokemonTypeEntity entity, PokemonTypeUpdateDto update);


}
