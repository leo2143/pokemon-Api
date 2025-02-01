package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.BaseStatisticsDto;
import com.pokemon_api.pokemon_api.dto.create.BaseStatisticsCreateDto;
import com.pokemon_api.pokemon_api.dto.update.BaseStatisticsUpdateDto;
import com.pokemon_api.pokemon_api.mapper.helpers.BaseStatisticsHelperMapper;
import com.pokemon_api.pokemon_api.model.BaseStatisticsEntity;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.WARN,uses = {BaseStatisticsHelperMapper.class})
public abstract class BaseStatisticsMapper extends DefaultMapper<BaseStatisticsDto, BaseStatisticsEntity, BaseStatisticsCreateDto, BaseStatisticsUpdateDto> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pokemon", ignore = true)
    public abstract BaseStatisticsEntity fromCreateDtoToEntity(BaseStatisticsCreateDto createDto);

    public abstract BaseStatisticsDto ToDto(BaseStatisticsEntity entity);

    public abstract List<BaseStatisticsDto> toListDto(List<BaseStatisticsEntity> entityList);

    @Mapping(target = "pokemon", ignore = true)
    public abstract BaseStatisticsEntity merge(@MappingTarget BaseStatisticsEntity entity, BaseStatisticsUpdateDto update);


}
