package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="pokemon")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_pokedex")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "peso")
    private Double weight;

    @Column(name = "altura")
    private Double height;
}
