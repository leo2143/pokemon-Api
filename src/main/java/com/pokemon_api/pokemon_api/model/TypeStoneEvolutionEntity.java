package com.pokemon_api.pokemon_api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "type_stone")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeStoneEvolutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_stone_id")
    private Long id;

    private String StoneName;

    @OneToOne(mappedBy = "typeStoneEvolution")
    private StoneEvolutionEntity stoneEvolution;
}
