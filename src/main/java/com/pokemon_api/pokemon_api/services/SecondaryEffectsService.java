package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.SecondaryEffectsDto;
import com.pokemon_api.pokemon_api.dto.create.SecondaryEffectsCreateDto;
import com.pokemon_api.pokemon_api.dto.update.SecondaryEffectsUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.SecondaryEffectsMapper;
import com.pokemon_api.pokemon_api.model.SecondaryEffectsEntity;
import com.pokemon_api.pokemon_api.repository.SecondaryEffectsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class SecondaryEffectsService extends DefaultService<SecondaryEffectsDto, SecondaryEffectsEntity, SecondaryEffectsCreateDto, SecondaryEffectsUpdateDto, Long> {

    private final SecondaryEffectsRepository repository;

    private final SecondaryEffectsMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("secondary.effects." + key, args);
    }
}
