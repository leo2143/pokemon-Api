package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.TypeStoneEvolutionDto;
import com.pokemon_api.pokemon_api.dto.create.TypeStoneEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.update.TypeStoneEvolutionUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.TypeStoneEvolutionMapper;
import com.pokemon_api.pokemon_api.model.TypeStoneEvolutionEntity;
import com.pokemon_api.pokemon_api.repository.TypeStoneEvolutionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@org.springframework.stereotype.Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class TypeStoneEvolutionService extends DefaultService<TypeStoneEvolutionDto, TypeStoneEvolutionEntity, TypeStoneEvolutionCreateDto, TypeStoneEvolutionUpdateDto, Long> {

    private final TypeStoneEvolutionRepository repository;

    private final TypeStoneEvolutionMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("type.stone.evolution." + key, args);
    }

}
