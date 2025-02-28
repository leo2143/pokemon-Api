package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.LevelEvolutionDto;
import com.pokemon_api.pokemon_api.dto.create.LevelEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.update.LevelEvolutionUpdateDto;
import com.pokemon_api.pokemon_api.model.LevelEvolutionEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {})
public abstract class LevelEvolutionMapper extends DefaultMapper<LevelEvolutionDto, LevelEvolutionEntity, LevelEvolutionCreateDto, LevelEvolutionUpdateDto> {

    @Mapping(target = "id", ignore = true)
    public abstract LevelEvolutionEntity fromCreateDtoToEntity(LevelEvolutionCreateDto createDto);

    public abstract LevelEvolutionDto ToDto(LevelEvolutionEntity entity);

    public abstract List<LevelEvolutionDto> toListDto(List<LevelEvolutionEntity> entityList);

    @Mapping(target = "id", ignore = true)
    public abstract LevelEvolutionEntity merge(@MappingTarget LevelEvolutionEntity entity, LevelEvolutionUpdateDto update);


}
