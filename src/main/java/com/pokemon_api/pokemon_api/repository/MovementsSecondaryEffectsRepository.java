
package com.pokemon_api.pokemon_api.repository;

import com.pokemon_api.pokemon_api.model.MovementsSecondaryEffectsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementsSecondaryEffectsRepository extends JpaRepository<MovementsSecondaryEffectsEntity, Long> {
}
