package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.MtLearnDto;
import com.pokemon_api.pokemon_api.dto.create.MtLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.update.MtLearnUpdateDto;
import com.pokemon_api.pokemon_api.model.MtLearnEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {})
public abstract class MtLearnMapper extends DefaultMapper<MtLearnDto, MtLearnEntity, MtLearnCreateDto, MtLearnUpdateDto> {

    @Mapping(target = "id", ignore = true)
    public abstract MtLearnEntity fromCreateDtoToEntity(MtLearnCreateDto createDto);

    public abstract MtLearnDto ToDto(MtLearnEntity entity);

    public abstract List<MtLearnDto> toListDto(List<MtLearnEntity> entityList);

    @Mapping(target = "id", ignore = true)
    public abstract MtLearnEntity merge(@MappingTarget MtLearnEntity entity, MtLearnUpdateDto update);


}
