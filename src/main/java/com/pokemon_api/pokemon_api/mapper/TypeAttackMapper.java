package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.TypeAttackDto;
import com.pokemon_api.pokemon_api.dto.create.TypeAttackCreateDto;
import com.pokemon_api.pokemon_api.dto.update.TypeAttackUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeAttackMapperHelper;
import com.pokemon_api.pokemon_api.model.TypeAttackEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = { TypeAttackMapperHelper.class})
public abstract class TypeAttackMapper extends DefaultMapper<TypeAttackDto, TypeAttackEntity, TypeAttackCreateDto, TypeAttackUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemonType", ignore = true)
    public abstract TypeAttackEntity fromCreateDtoToEntity(TypeAttackCreateDto createDto);

    public abstract TypeAttackDto ToDto(TypeAttackEntity entity);

    public abstract List<TypeAttackDto> toListDto(List<TypeAttackEntity> entityList);

    @Mapping(target = "pokemonType", ignore = true)
    public abstract TypeAttackEntity merge(@MappingTarget TypeAttackEntity entity, TypeAttackUpdateDto update);


}
