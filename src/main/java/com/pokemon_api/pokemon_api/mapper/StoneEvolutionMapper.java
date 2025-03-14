package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.StoneEvolutionDto;
import com.pokemon_api.pokemon_api.dto.create.StoneEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.update.StoneEvolutionUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeEvolutionMapperHelper;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeStoneEvolutionMapperHelper;
import com.pokemon_api.pokemon_api.model.StoneEvolutionEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {TypeStoneEvolutionMapper.class, TypeStoneEvolutionMapperHelper.class, TypeEvolutionMapperHelper.class})
public abstract class StoneEvolutionMapper extends DefaultMapper<StoneEvolutionDto, StoneEvolutionEntity, StoneEvolutionCreateDto, StoneEvolutionUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemons", ignore = true)
    @Mapping(target = "typeStoneEvolution", source = "typeStoneId", qualifiedByName = "KeyToTypeStoneEntity")
    @Mapping(target = "typeEvolution",source = "typeEvolutionName", qualifiedByName = "KeyToTypeEvolutionEntity")
    public abstract StoneEvolutionEntity fromCreateDtoToEntity(StoneEvolutionCreateDto createDto);

    public abstract StoneEvolutionDto ToDto(StoneEvolutionEntity entity);

    public abstract List<StoneEvolutionDto> toListDto(List<StoneEvolutionEntity> entityList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemons", ignore = true)
    @Mapping(target = "typeStoneEvolution", source = "typeStoneId", qualifiedByName = "KeyToTypeStoneEntity")
    @Mapping(target = "typeEvolution",source = "typeEvolutionName", qualifiedByName = "KeyToTypeEvolutionEntity")
    public abstract StoneEvolutionEntity merge(@MappingTarget StoneEvolutionEntity entity, StoneEvolutionUpdateDto update);


}
