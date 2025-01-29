package com.pokemon_api.pokemon_api.mapper;

import com.pokemon_api.pokemon_api.common.DefaultMapper;
import com.pokemon_api.pokemon_api.dto.PokemonDto;
import com.pokemon_api.pokemon_api.dto.create.PokemonCreateDto;
import com.pokemon_api.pokemon_api.dto.update.PokemonUpdateDto;
import com.pokemon_api.pokemon_api.model.PokemonEntity;
import com.pokemon_api.pokemon_api.model.PokemonTypeEntity;
import com.pokemon_api.pokemon_api.repository.PokemonTypesRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.WARN
)
@AllArgsConstructor
public abstract class PokemonMapper extends DefaultMapper<PokemonDto, PokemonEntity, PokemonCreateDto, PokemonUpdateDto> {

    private final PokemonTypesRepository pokemonTypesRepository;

    @Mapping(target = "id", ignore = true)
    public abstract PokemonEntity fromCreateDtoToEntity(PokemonCreateDto createDto);

    public abstract PokemonDto ToDto(PokemonEntity createDto);

    public abstract List<PokemonDto> toListDto(List<PokemonEntity> entityList);

    @Mapping(target = "types", source = "typeIds", qualifiedByName = "idsToEntity")
    public abstract PokemonEntity merge(@MappingTarget PokemonEntity entity, PokemonUpdateDto update);

    @Named("idsToEntity")
    public Set<PokemonTypeEntity> idsToEntity(Set<Long> typesIds) {

        try {
            if (typesIds.isEmpty()) {
                return null;
            }
            List<PokemonTypeEntity> pokemons =  pokemonTypesRepository.findAllById(typesIds);
            if (pokemons.isEmpty()) {
                return null;
            }
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

}
