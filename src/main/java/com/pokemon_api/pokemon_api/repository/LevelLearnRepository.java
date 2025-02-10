package com.pokemon_api.pokemon_api.repository;

import com.pokemon_api.pokemon_api.model.LevelLearnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelLearnRepository extends JpaRepository<LevelLearnEntity, Long> {
}
