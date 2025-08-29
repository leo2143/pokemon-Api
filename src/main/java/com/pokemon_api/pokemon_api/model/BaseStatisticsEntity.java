package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Embeddable
public class BaseStatisticsEntity {

    private int ps;

    private int attack;

    private int defense;

    private int special;

    private int speed;


}
