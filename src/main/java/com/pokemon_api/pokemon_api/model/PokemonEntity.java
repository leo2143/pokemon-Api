package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pokemon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pokedex_number")
    private Long id;

    private String name;

    private Double weight;

    private Double height;

    @ManyToMany
    @JoinTable(
            name = "pokemon_types",
            joinColumns = @JoinColumn(name = "pokedex_number"),
            inverseJoinColumns = @JoinColumn(name = "types")

    )
    private Set<TypeEntity> types = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "pokemon_form_evolution",
            joinColumns = @JoinColumn(name = "pokedex_number"),
            inverseJoinColumns = @JoinColumn(name = "form_evolution_id")

    )
    private Set<FormEvolutionEntity> formEvolutions = new HashSet<>();

    @JoinColumn(name = "evolution_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PokemonEntity evolution;

    @Embedded
    private BaseStatisticsEntity baseStatistics;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pokemon")
    private List<PokemonMovementForm> pokemonMovementForms;

}
