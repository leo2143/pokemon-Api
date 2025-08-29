package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.FormEvolutionDto;
import com.pokemon_api.pokemon_api.dto.create.FormEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.update.FormEvolutionUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.FormEvolutionMapperHelper;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeEvolutionMapperHelper;
import com.pokemon_api.pokemon_api.model.FormEvolutionEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {TypeEvolutionMapperHelper.class,FormEvolutionMapperHelper.class,StoneEvolutionMapper.class, LevelEvolutionMapper.class})
public abstract class FormEvolutionMapper extends DefaultMapper<FormEvolutionDto, FormEvolutionEntity, FormEvolutionCreateDto, FormEvolutionUpdateDto> {

    @Mapping(target = "typeEvolution", source = "typeEvolutionName",qualifiedByName = "KeyToTypeEvolutionEntity")
    @Mapping(target = "pokemons", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract FormEvolutionEntity fromCreateDtoToEntity(FormEvolutionCreateDto createDto);

    public abstract FormEvolutionDto ToDto(FormEvolutionEntity entity);

    public abstract List<FormEvolutionDto> toListDto(List<FormEvolutionEntity> entityList);

    @Mapping(target = "typeEvolution", source = "typeEvolutionName",qualifiedByName = "KeyToTypeEvolutionEntity")
    @Mapping(target = "pokemons", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract FormEvolutionEntity merge(@MappingTarget FormEvolutionEntity entity, FormEvolutionUpdateDto update);

}
