package com.pokemon_api.pokemon_api.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pokemon_movement_form")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonMovementForm {

    @Id
    @ManyToOne
    @JoinColumn(name = "pokedex_number")
    private PokemonEntity pokemon;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_movements")
    private MovementsSecondaryEffectsEntity movementsSecondaryEffects;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_form_learn")
    private FormLearnEntity formLearn;
}
