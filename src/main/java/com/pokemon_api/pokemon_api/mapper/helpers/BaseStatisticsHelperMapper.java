package com.pokemon_api.pokemon_api.mapper.helpers;

import com.pokemon_api.pokemon_api.dto.create.BaseStatisticsCreateDto;
import com.pokemon_api.pokemon_api.mapper.BaseStatisticsMapper;
import com.pokemon_api.pokemon_api.model.BaseStatisticsEntity;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BaseStatisticsHelperMapper {

    private final BaseStatisticsMapper baseStatisticsMapper;

    @Named("mapBaseStatistics")
    public BaseStatisticsEntity mapBaseStatistics(BaseStatisticsCreateDto createDto) {
        if (createDto == null) {
            return null;
        }
        // Aquí mapeas el BaseStatisticsCreateDto a BaseStatisticsEntity
        BaseStatisticsEntity baseStatisticsEntity = baseStatisticsMapper.fromCreateDtoToEntity(createDto);
        return baseStatisticsEntity;
    }

}
