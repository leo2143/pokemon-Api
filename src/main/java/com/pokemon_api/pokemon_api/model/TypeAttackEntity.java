package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "type_attack")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeAttackEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_attack_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "typeAttack", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TypeEntity> pokemonType;
}
