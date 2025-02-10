package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.MoLearnDto;
import com.pokemon_api.pokemon_api.dto.create.MoLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.update.MoLearnUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.MoLearnMapper;
import com.pokemon_api.pokemon_api.model.MoLearnEntity;
import com.pokemon_api.pokemon_api.repository.MoLearnRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;


@org.springframework.stereotype.Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class MoLearnService extends DefaultService<MoLearnDto, MoLearnEntity, MoLearnCreateDto, MoLearnUpdateDto, Long> {

    private final MoLearnRepository repository;

    private final MoLearnMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("mo.learn." + key, args);
    }

}
