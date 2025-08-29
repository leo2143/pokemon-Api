package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.TypeFormLearnDto;
import com.pokemon_api.pokemon_api.dto.create.TypeFormLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.update.TypeFormLearnUpdateDto;
import com.pokemon_api.pokemon_api.model.TypeFormLearnEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {})
public abstract class TypeFormLearnMapper extends DefaultMapper<TypeFormLearnDto, TypeFormLearnEntity, TypeFormLearnCreateDto, TypeFormLearnUpdateDto> {

    @Mapping(target = "formLearn", ignore = true)
    @Mapping(target = "id", ignore = true)
    public abstract TypeFormLearnEntity fromCreateDtoToEntity(TypeFormLearnCreateDto createDto);

    public abstract TypeFormLearnDto ToDto(TypeFormLearnEntity entity);

    public abstract List<TypeFormLearnDto> toListDto(List<TypeFormLearnEntity> entityList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "formLearn", ignore = true)
    public abstract TypeFormLearnEntity merge(@MappingTarget TypeFormLearnEntity entity, TypeFormLearnUpdateDto update);


}
