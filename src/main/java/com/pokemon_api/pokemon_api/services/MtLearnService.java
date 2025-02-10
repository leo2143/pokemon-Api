package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.MtLearnDto;
import com.pokemon_api.pokemon_api.dto.create.MtLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.update.MtLearnUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.MtLearnMapper;
import com.pokemon_api.pokemon_api.model.MtLearnEntity;
import com.pokemon_api.pokemon_api.repository.MtLearnRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class MtLearnService extends DefaultService<MtLearnDto, MtLearnEntity, MtLearnCreateDto, MtLearnUpdateDto, Long> {

    private final MtLearnRepository repository;

    private final MtLearnMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("mt.learn." + key, args);
    }

}
