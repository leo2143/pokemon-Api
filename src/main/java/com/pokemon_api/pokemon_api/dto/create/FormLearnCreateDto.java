package com.pokemon_api.pokemon_api.dto.create;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class FormLearnCreateDto {

    @JsonIgnore
    private String formLearn;


}
