package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.MovementsSecondaryEffectsDto;
import com.pokemon_api.pokemon_api.dto.create.MovementsSecondaryEffectsCreateDto;
import com.pokemon_api.pokemon_api.dto.update.MovementsSecondaryEffectsUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.MovementsHelper;
import com.pokemon_api.pokemon_api.mapper.helpers.SecondaryEffectsMapperHelper;
import com.pokemon_api.pokemon_api.model.MovementsSecondaryEffectsEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {SecondaryEffectsMapper.class, SecondaryEffectsMapperHelper.class, MovementsMapper.class, MovementsHelper.class})
public abstract class MovementsSecondaryEffectsMapper extends DefaultMapper<MovementsSecondaryEffectsDto, MovementsSecondaryEffectsEntity, MovementsSecondaryEffectsCreateDto, MovementsSecondaryEffectsUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "movements", source = "movementsId", qualifiedByName = "KeyToMovementsEntity")
    @Mapping(target = "secondaryEffects", source = "secondaryEffectsId", qualifiedByName = "KeyToSecondaryEffectsEntity")
    @Mapping(target = "pokemonMovementForms", ignore = true)

    public abstract MovementsSecondaryEffectsEntity fromCreateDtoToEntity(MovementsSecondaryEffectsCreateDto createDto);

    public abstract MovementsSecondaryEffectsDto ToDto(MovementsSecondaryEffectsEntity entity);

    public abstract List<MovementsSecondaryEffectsDto> toListDto(List<MovementsSecondaryEffectsEntity> entityList);

    @Mapping(target = "movements", source = "movementsId", qualifiedByName = "KeyToMovementsEntity")
    @Mapping(target = "secondaryEffects", source = "secondaryEffectsId", qualifiedByName = "KeyToSecondaryEffectsEntity")
    @Mapping(target = "pokemonMovementForms", ignore = true)
    public abstract MovementsSecondaryEffectsEntity merge(@MappingTarget MovementsSecondaryEffectsEntity entity, MovementsSecondaryEffectsUpdateDto update);


}
