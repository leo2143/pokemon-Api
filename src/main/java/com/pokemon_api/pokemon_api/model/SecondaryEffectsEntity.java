package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "secondary_efects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondaryEffectsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "secondary_efect")
    private String secondaryEffect;

    @OneToMany(mappedBy = "secondaryEffects")
    private Set<MovementsSecondaryEffectsEntity> movementSecondaryEffects = new HashSet<>();
}
