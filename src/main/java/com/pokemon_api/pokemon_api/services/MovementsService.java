package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.MovementsDto;
import com.pokemon_api.pokemon_api.dto.create.MovementsCreateDto;
import com.pokemon_api.pokemon_api.dto.update.MovementsUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.MovementsMapper;
import com.pokemon_api.pokemon_api.model.MovementsEntity;
import com.pokemon_api.pokemon_api.repository.MovementsRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@org.springframework.stereotype.Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class MovementsService extends DefaultService<MovementsDto, MovementsEntity, MovementsCreateDto, MovementsUpdateDto, Long> {

    private final MovementsRepository repository;

    private final MovementsMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("movements." + key, args);
    }

}
