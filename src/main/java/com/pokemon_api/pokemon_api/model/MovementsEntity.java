package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movements")
public class MovementsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long strenght;

    @Column(name = "precision_mov")
    private Long precisionMov;

    @Column(length = 500)
    private String description;

    @OneToMany(mappedBy = "movements")
    private Set<MovementsSecondaryEffectsEntity> movementsSecondaryEffects = new HashSet<>();

    private int pp;

    private int priority;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private TypeEntity type;

}
