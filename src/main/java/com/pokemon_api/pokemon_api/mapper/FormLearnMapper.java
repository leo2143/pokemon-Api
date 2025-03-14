package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.FormLearnDto;
import com.pokemon_api.pokemon_api.dto.create.FormLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.update.FormLearnUpdateDto;
import com.pokemon_api.pokemon_api.model.FormLearnEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {LevelLearnMapper.class, MoLearnMapper.class, MtLearnMapper.class})
public abstract class FormLearnMapper extends DefaultMapper<FormLearnDto, FormLearnEntity, FormLearnCreateDto, FormLearnUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemonMovementForms",ignore = true)
    public abstract FormLearnEntity fromCreateDtoToEntity(FormLearnCreateDto createDto);

    public abstract FormLearnDto ToDto(FormLearnEntity entity);

    public abstract List<FormLearnDto> toListDto(List<FormLearnEntity> entityList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemonMovementForms",ignore = true)
    public abstract FormLearnEntity merge(@MappingTarget FormLearnEntity entity, FormLearnUpdateDto update);

}
