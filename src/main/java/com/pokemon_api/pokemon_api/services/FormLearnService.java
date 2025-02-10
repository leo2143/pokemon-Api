package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.FormLearnDto;
import com.pokemon_api.pokemon_api.dto.create.FormLearnCreateDto;
import com.pokemon_api.pokemon_api.dto.update.FormLearnUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.FormLearnMapper;
import com.pokemon_api.pokemon_api.model.FormLearnEntity;
import com.pokemon_api.pokemon_api.repository.FormLearnRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class FormLearnService extends DefaultService<FormLearnDto, FormLearnEntity, FormLearnCreateDto, FormLearnUpdateDto, Long> {

    private final FormLearnRepository repository;

    private final FormLearnMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("form.learn." + key, args);
    }

}
