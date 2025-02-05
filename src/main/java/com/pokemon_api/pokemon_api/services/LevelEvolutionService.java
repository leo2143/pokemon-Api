package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.LevelEvolutionDto;
import com.pokemon_api.pokemon_api.dto.create.LevelEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.update.LevelEvolutionUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.LevelEvolutionMapper;
import com.pokemon_api.pokemon_api.model.LevelEvolutionEntity;
import com.pokemon_api.pokemon_api.repository.LevelEvolutionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@org.springframework.stereotype.Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class LevelEvolutionService extends DefaultService<LevelEvolutionDto, LevelEvolutionEntity, LevelEvolutionCreateDto, LevelEvolutionUpdateDto, Long> {

    private final LevelEvolutionRepository repository;

    private final LevelEvolutionMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("Level.evolution." + key, args);
    }

}
