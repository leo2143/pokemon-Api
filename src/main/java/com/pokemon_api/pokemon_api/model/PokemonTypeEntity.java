package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "pokemon_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "types")
    private Set<PokemonEntity> pokemons;
}
