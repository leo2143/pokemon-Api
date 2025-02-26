package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "movement_secondary_effects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovementsSecondaryEffectsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movements_id")
    private MovementsEntity movements;

    @ManyToOne
    @JoinColumn(name = "secondary_effects_id")
    private SecondaryEffectsEntity secondaryEffects;

    private int probability;
}
