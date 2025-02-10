package com.pokemon_api.pokemon_api.repository;

import com.pokemon_api.pokemon_api.model.FormEvolutionEntity;
import com.pokemon_api.pokemon_api.model.StoneEvolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormEvolutionRepository extends JpaRepository<FormEvolutionEntity, Long> {
}
