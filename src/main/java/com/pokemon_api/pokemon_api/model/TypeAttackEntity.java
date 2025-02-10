package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne(mappedBy = "typeAttack", cascade = CascadeType.ALL)
    private TypeEntity pokemonType;
}
