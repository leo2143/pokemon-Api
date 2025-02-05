package com.pokemon_api.pokemon_api.repository;

import com.pokemon_api.pokemon_api.model.TypeStoneEvolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeStoneEvolutionRepository extends JpaRepository<TypeStoneEvolutionEntity, Long> {
}
