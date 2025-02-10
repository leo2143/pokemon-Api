package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.FormEvolutionDto;
import com.pokemon_api.pokemon_api.dto.create.FormEvolutionCreateDto;
import com.pokemon_api.pokemon_api.dto.update.FormEvolutionUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.FormEvolutionMapper;
import com.pokemon_api.pokemon_api.model.FormEvolutionEntity;
import com.pokemon_api.pokemon_api.repository.FormEvolutionRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class FormEvolutionService extends DefaultService<FormEvolutionDto, FormEvolutionEntity, FormEvolutionCreateDto, FormEvolutionUpdateDto, Long> {

    private final FormEvolutionRepository repository;

    private final FormEvolutionMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("form.evolution." + key, args);
    }

}
