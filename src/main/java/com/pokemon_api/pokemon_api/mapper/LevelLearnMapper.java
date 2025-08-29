package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.LevelLearnDto;
import com.pokemon_api.pokemon_api.dto.create.LevelLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.update.LevelLearnUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeFormLearnMapperHelper;
import com.pokemon_api.pokemon_api.model.LevelLearnEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN, uses = {TypeFormLearnMapperHelper.class, TypeFormLearnMapper.class})
public abstract class LevelLearnMapper extends DefaultMapper<LevelLearnDto, LevelLearnEntity, LevelLearnCreateDto, LevelLearnUpdateDto> {

    @Mapping(target = "typeLearnForm", source = "typeLearnFormId", qualifiedByName = "KeyToEntity")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemonMovementForms",ignore = true)
    public abstract LevelLearnEntity fromCreateDtoToEntity(LevelLearnCreateDto createDto);

    public abstract LevelLearnDto ToDto(LevelLearnEntity entity);

    public abstract List<LevelLearnDto> toListDto(List<LevelLearnEntity> entityList);

    @Mapping(target = "pokemonMovementForms",ignore = true)
    @Mapping(target = "typeLearnForm", source = "typeLearnFormId", qualifiedByName = "KeyToEntity")
    @Mapping(target = "id", ignore = true)
    public abstract LevelLearnEntity merge(@MappingTarget LevelLearnEntity entity, LevelLearnUpdateDto update);


}
