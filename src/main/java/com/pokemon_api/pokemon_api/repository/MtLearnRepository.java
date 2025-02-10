package com.pokemon_api.pokemon_api.repository;

import com.pokemon_api.pokemon_api.model.MtLearnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MtLearnRepository extends JpaRepository<MtLearnEntity, Long> {
}
