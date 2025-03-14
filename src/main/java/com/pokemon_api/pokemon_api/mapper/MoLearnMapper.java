package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.MoLearnDto;
import com.pokemon_api.pokemon_api.dto.create.MoLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.update.MoLearnUpdateDto;
import com.pokemon_api.pokemon_api.model.MoLearnEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {})
public abstract class MoLearnMapper extends DefaultMapper<MoLearnDto, MoLearnEntity, MoLearnCreateDto, MoLearnUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemonMovementForms", ignore = true)
    public abstract MoLearnEntity fromCreateDtoToEntity(MoLearnCreateDto createDto);

    public abstract MoLearnDto ToDto(MoLearnEntity entity);

    public abstract List<MoLearnDto> toListDto(List<MoLearnEntity> entityList);

    @Mapping(target = "pokemonMovementForms", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract MoLearnEntity merge(@MappingTarget MoLearnEntity entity, MoLearnUpdateDto update);


}
