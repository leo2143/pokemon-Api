package com.pokemon_api.pokemon_api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stone")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class StoneEvolutionEntity extends FormEvolutionEntity {

    @OneToOne
    @JoinColumn(name = "type_stone_id", nullable = false, unique = true)
    private TypeStoneEvolutionEntity typeStoneEvolution;


}
