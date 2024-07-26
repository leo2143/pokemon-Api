package com.pokemon_api.pokemon_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomResponse {

    private int statusCode;

    private String message;

    private Object data;

}
