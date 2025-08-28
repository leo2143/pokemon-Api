package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.dto.TypeEvolutionDto;
import com.pokemon_api.pokemon_api.dto.create.TypeEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.update.TypeEvolutionUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeAttackMapperHelper;
import com.pokemon_api.pokemon_api.model.TypeEvolutionEntity;
import org.mapstruct.*;

import java.util.List;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = { TypeAttackMapperHelper.class})
public abstract class TypeEvolutionMapper {

    @Mapping(target = "id", ignore = true)
    public abstract TypeEvolutionEntity fromCreateDtoToEntity(TypeEvolutionCreateDto createDto);

    public abstract TypeEvolutionDto ToDto(TypeEvolutionEntity entity);

    public abstract List<TypeEvolutionDto> toListDto(List<TypeEvolutionEntity> entityList);

    @Mapping(target = "id", ignore = true)
    public abstract TypeEvolutionEntity merge(@MappingTarget TypeEvolutionEntity entity, TypeEvolutionUpdateDto update);



}
