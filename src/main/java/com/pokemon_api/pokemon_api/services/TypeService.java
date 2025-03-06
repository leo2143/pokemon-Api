package com.pokemon_api.pokemon_api.services;

import com.pokemon_api.pokemon_api.common.CustomResponse;
import com.pokemon_api.pokemon_api.common.DefaultService;
import com.pokemon_api.pokemon_api.dto.TypeDto;
import com.pokemon_api.pokemon_api.dto.create.TypeCreateDto;
import com.pokemon_api.pokemon_api.dto.update.TypeUpdateDto;
import com.pokemon_api.pokemon_api.i18n.I18nUtil;
import com.pokemon_api.pokemon_api.mapper.TypeMapper;
import com.pokemon_api.pokemon_api.model.TypeEntity;
import com.pokemon_api.pokemon_api.repository.TypeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class TypeService extends DefaultService<TypeDto, TypeEntity, TypeCreateDto, TypeUpdateDto, Long> {

    private final TypeRepository repository;

    private final TypeMapper mapper;

    private final I18nUtil i18nUtil;

    public ResponseEntity<?> testPage (Pageable pageable){
        CustomResponse customResponse = new CustomResponse(200,"ok",repository.findAll(pageable));
       return ResponseEntity.ok().body(customResponse);
    }

    @Override
    public String getI8nMessage(String key, Object[] args) {
        return i18nUtil.getMessage("type." + key, args);
    }
}
