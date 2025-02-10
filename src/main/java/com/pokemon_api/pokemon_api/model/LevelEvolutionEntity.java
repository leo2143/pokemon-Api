package com.pokemon_api.pokemon_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nivel_evolucion")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class LevelEvolutionEntity extends FormEvolutionEntity {

    private int level;

    @PrePersist
    public void prePersist() {
        setFormEvolution("Nivel");
    }

}
