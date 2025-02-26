
package com.pokemon_api.pokemon_api.repository;

import com.pokemon_api.pokemon_api.model.MovementsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementsRepository extends JpaRepository<MovementsEntity, Long> {
}
