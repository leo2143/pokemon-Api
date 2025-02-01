package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.PokemonDto;
import com.pokemon_api.pokemon_api.dto.create.PokemonCreateDto;
import com.pokemon_api.pokemon_api.dto.update.PokemonUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.PokemonMapper;
import com.pokemon_api.pokemon_api.model.PokemonEntity;
import com.pokemon_api.pokemon_api.repository.PokemonRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class PokemonService extends DefaultService<PokemonDto, PokemonEntity, PokemonCreateDto, PokemonUpdateDto, Long> {

    private final PokemonRepository repository;

    private final PokemonMapper mapper;

    private final I18nUtil i18nUtil;

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("pokemon." + key, args);
    }

    @Override
    public ResponseEntity<?> create(PokemonCreateDto create) {
        return super.create(create);
    }

}
