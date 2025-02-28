package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.MovementsSecondaryEffectsDto;
import com.pokemon_api.pokemon_api.dto.create.MovementsSecondaryEffectsCreateDto;
import com.pokemon_api.pokemon_api.dto.update.MovementsSecondaryEffectsUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.MovementsSecondaryEffectsMapper;
import com.pokemon_api.pokemon_api.model.MovementsSecondaryEffectsEntity;
import com.pokemon_api.pokemon_api.repository.MovementsSecondaryEffectsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class MovementsSecondaryEffectsService extends DefaultService<MovementsSecondaryEffectsDto, MovementsSecondaryEffectsEntity, MovementsSecondaryEffectsCreateDto, MovementsSecondaryEffectsUpdateDto, Long> {

    private final MovementsSecondaryEffectsRepository repository;

    private final MovementsSecondaryEffectsMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("movements.secondary.effects" + key, args);
    }

}
