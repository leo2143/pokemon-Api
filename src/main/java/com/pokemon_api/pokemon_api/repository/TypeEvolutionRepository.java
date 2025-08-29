package com.pokemon_api.pokemon_api.repository;

import com.pokemon_api.pokemon_api.model.TypeEvolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeEvolutionRepository extends JpaRepository<TypeEvolutionEntity, Long> {

    Optional<TypeEvolutionEntity>findByTypeEvolution(String typeEvolution);

}
