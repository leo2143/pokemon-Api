package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.TypeDto;
import com.pokemon_api.pokemon_api.dto.create.TypeCreateDto;
import com.pokemon_api.pokemon_api.dto.update.TypeUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeAttackMapperHelper;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeMapperHelper;
import com.pokemon_api.pokemon_api.model.TypeEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = { TypeMapperHelper.class, TypeAttackMapperHelper.class})
public abstract class TypeMapper extends DefaultMapper<TypeDto, TypeEntity, TypeCreateDto, TypeUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemons", ignore = true)
    @Mapping(target = "typeAttack", source = "typeAttackId", qualifiedByName = "KeyToEntity")
    public abstract TypeEntity fromCreateDtoToEntity(TypeCreateDto createDto);

    public abstract TypeDto ToDto(TypeEntity entity);

    public abstract List<TypeDto> toListDto(List<TypeEntity> entityList);

    @Mapping(target = "pokemons", ignore = true)
    @Mapping(target = "typeAttack", source = "typeAttackId", qualifiedByName = "KeyToEntity")
    public abstract TypeEntity merge(@MappingTarget TypeEntity entity, TypeUpdateDto update);


}
