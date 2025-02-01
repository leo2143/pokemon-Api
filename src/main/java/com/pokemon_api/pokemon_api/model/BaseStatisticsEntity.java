package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "base_statistics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseStatisticsEntity {

    @Id
    private Long id;

    private String ps;

    private String attack;

    private String defense;

    private String special;

    private String speed;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @MapsId
    private PokemonEntity pokemon;

}
