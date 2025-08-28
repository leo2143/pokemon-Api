package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.MtLearnDto;
import com.pokemon_api.pokemon_api.dto.create.MtLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.update.MtLearnUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.TypeFormLearnMapperHelper;
import com.pokemon_api.pokemon_api.model.MtLearnEntity;
import com.pokemon_api.pokemon_api.model.TypeFormLearnEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {TypeFormLearnMapper.class, TypeFormLearnMapperHelper.class})
public abstract class MtLearnMapper extends DefaultMapper<MtLearnDto, MtLearnEntity, MtLearnCreateDto, MtLearnUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemonMovementForms",ignore = true)
    @Mapping(target = "typeLearnForm", source = "typeLearnFormId",qualifiedByName = "KeyToEntity")

    public abstract MtLearnEntity fromCreateDtoToEntity(MtLearnCreateDto createDto);

    public abstract MtLearnDto ToDto(MtLearnEntity entity);

    public abstract List<MtLearnDto> toListDto(List<MtLearnEntity> entityList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemonMovementForms",ignore = true)
    @Mapping(target = "typeLearnForm", source = "typeLearnFormId",qualifiedByName = "KeyToEntity")
    public abstract MtLearnEntity merge(@MappingTarget MtLearnEntity entity, MtLearnUpdateDto update);


}
