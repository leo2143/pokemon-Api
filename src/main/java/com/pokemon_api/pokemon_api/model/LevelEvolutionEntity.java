package com.pokemon_api.pokemon_api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "nivel_evolucion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LevelEvolutionEntity extends FormEvolutionEntity {

    private int level;

    @PrePersist
    public void prePersist() {
        setFormEvolution("Nivel");
    }

}
