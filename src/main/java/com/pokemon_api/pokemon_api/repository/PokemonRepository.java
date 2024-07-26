package com.pokemon_api.pokemon_api.repository;

import com.pokemon_api.pokemon_api.model.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
}
