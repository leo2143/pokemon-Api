package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.StoneEvolutionDto;
import com.pokemon_api.pokemon_api.dto.create.StoneEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.update.StoneEvolutionUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.StoneEvolutionMapper;
import com.pokemon_api.pokemon_api.model.StoneEvolutionEntity;
import com.pokemon_api.pokemon_api.repository.StoneEvolutionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@org.springframework.stereotype.Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class StoneEvolutionService extends DefaultService<StoneEvolutionDto, StoneEvolutionEntity, StoneEvolutionCreateDto, StoneEvolutionUpdateDto, Long> {

    private final StoneEvolutionRepository repository;

    private final StoneEvolutionMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("stone.evolution." + key, args);
    }

}
