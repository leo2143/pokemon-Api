package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "types")
    private Set<PokemonEntity> pokemons;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_attack_id")
    private TypeAttackEntity typeAttack;
}
