package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.SecondaryEffectsDto;
import com.pokemon_api.pokemon_api.dto.create.SecondaryEffectsCreateDto;
import com.pokemon_api.pokemon_api.dto.update.SecondaryEffectsUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.SecondaryEffectsMapperHelper;
import com.pokemon_api.pokemon_api.model.SecondaryEffectsEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {SecondaryEffectsMapperHelper.class})
public abstract class SecondaryEffectsMapper extends DefaultMapper<SecondaryEffectsDto, SecondaryEffectsEntity, SecondaryEffectsCreateDto, SecondaryEffectsUpdateDto> {

    @Mapping(target = "movementSecondaryEffects", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract SecondaryEffectsEntity fromCreateDtoToEntity(SecondaryEffectsCreateDto createDto);

    public abstract SecondaryEffectsDto ToDto(SecondaryEffectsEntity entity);

    public abstract List<SecondaryEffectsDto> toListDto(List<SecondaryEffectsEntity> entityList);

    @Mapping(target = "movementSecondaryEffects", ignore = true)
    public abstract SecondaryEffectsEntity merge(@MappingTarget SecondaryEffectsEntity entity, SecondaryEffectsUpdateDto update);


}
