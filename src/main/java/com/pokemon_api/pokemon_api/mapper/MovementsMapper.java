package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.MovementsDto;
import com.pokemon_api.pokemon_api.dto.create.MovementsCreateDto;
import com.pokemon_api.pokemon_api.dto.update.MovementsUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.SecondaryEffectsMapperHelper;
import com.pokemon_api.pokemon_api.model.MovementsEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {})
public abstract class MovementsMapper extends DefaultMapper<MovementsDto, MovementsEntity, MovementsCreateDto, MovementsUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movementsSecondaryEffects", ignore = true)
    public abstract MovementsEntity fromCreateDtoToEntity(MovementsCreateDto createDto);

    public abstract MovementsDto ToDto(MovementsEntity entity);

    public abstract List<MovementsDto> toListDto(List<MovementsEntity> entityList);

    @Mapping(target = "movementsSecondaryEffects", ignore = true)
    public abstract MovementsEntity merge(@MappingTarget MovementsEntity entity, MovementsUpdateDto update);


}
