package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.LevelLearnDto;
import com.pokemon_api.pokemon_api.dto.create.LevelLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.update.LevelLearnUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.LevelLearnMapper;
import com.pokemon_api.pokemon_api.model.LevelLearnEntity;
import com.pokemon_api.pokemon_api.repository.LevelLearnRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class LevelLearnService extends DefaultService<LevelLearnDto, LevelLearnEntity, LevelLearnCreateDto, LevelLearnUpdateDto, Long> {

    private final LevelLearnRepository repository;

    private final LevelLearnMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("level.learn." + key, args);
    }

}
