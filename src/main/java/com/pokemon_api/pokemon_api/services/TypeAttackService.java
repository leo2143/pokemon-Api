package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.TypeAttackDto;
import com.pokemon_api.pokemon_api.dto.create.TypeAttackCreateDto;
import com.pokemon_api.pokemon_api.dto.update.TypeAttackUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.TypeAttackMapper;
import com.pokemon_api.pokemon_api.model.TypeAttackEntity;
import com.pokemon_api.pokemon_api.repository.TypeAttackRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class TypeAttackService extends DefaultService<TypeAttackDto, TypeAttackEntity, TypeAttackCreateDto, TypeAttackUpdateDto, Long> {

    private final TypeAttackRepository repository;

    private final TypeAttackMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("type.attack." + key, args);
    }

}
