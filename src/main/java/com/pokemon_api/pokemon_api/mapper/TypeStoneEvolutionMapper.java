package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.TypeStoneEvolutionDto;
import com.pokemon_api.pokemon_api.dto.create.TypeStoneEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.update.TypeStoneEvolutionUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeStoneEvolutionMapperHelper;
import com.pokemon_api.pokemon_api.model.TypeStoneEvolutionEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {})
public abstract class TypeStoneEvolutionMapper extends DefaultMapper<TypeStoneEvolutionDto, TypeStoneEvolutionEntity, TypeStoneEvolutionCreateDto, TypeStoneEvolutionUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stoneEvolution", ignore = true)
    public abstract TypeStoneEvolutionEntity fromCreateDtoToEntity(TypeStoneEvolutionCreateDto createDto);

    public abstract TypeStoneEvolutionDto ToDto(TypeStoneEvolutionEntity entity);

    public abstract List<TypeStoneEvolutionDto> toListDto(List<TypeStoneEvolutionEntity> entityList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "stoneEvolution", ignore = true)
    public abstract TypeStoneEvolutionEntity merge(@MappingTarget TypeStoneEvolutionEntity entity, TypeStoneEvolutionUpdateDto update);


}
