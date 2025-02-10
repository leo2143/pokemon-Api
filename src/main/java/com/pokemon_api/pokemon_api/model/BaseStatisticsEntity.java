package com.pokemon_api.pokemon_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Embeddable
public class BaseStatisticsEntity {

    private String ps;

    private String attack;

    private String defense;

    private String special;

    private String speed;


}
