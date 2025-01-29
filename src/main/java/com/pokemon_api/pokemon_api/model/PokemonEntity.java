package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
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
    private Set<PokemonTypeEntity> types = new HashSet<>();

    @JoinColumn(name = "evolution_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PokemonEntity evolution;
}
